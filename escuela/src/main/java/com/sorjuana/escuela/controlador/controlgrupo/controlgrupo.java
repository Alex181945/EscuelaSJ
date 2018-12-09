package com.sorjuana.escuela.controlador.controlgrupo;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.MensajeError;
import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.controlador.kardex.GeneraKardexPDF;
import com.sorjuana.escuela.modelo.ct.Alumno;
import com.sorjuana.escuela.modelo.ct.Carrera;
import com.sorjuana.escuela.modelo.ct.Grupo;
import com.sorjuana.escuela.modelo.ct.GrupoDetalle;
import com.sorjuana.escuela.modelo.ct.Periodo;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.carrera.CarreraRest;
import com.sorjuana.escuela.repositorio.grupo.GrupoRest;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;
import com.sorjuana.escuela.repositorio.periodo.PeriodoRest;


@Controller
@SessionAttributes("Persona")
public class controlgrupo {
	
	@Autowired
	private MenuRest menuRest;
	
	@Autowired
	private GrupoRest grupoRest;
	
	@Autowired
	private CarreraRest carreraRest;
	
	@Autowired
	private PeriodoRest periodoRest;

	@GetMapping("/catalogo/grupo/consulta")
	public ModelAndView consulta(@ModelAttribute("Persona") Usuario sesionPersona) {

		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getConsultagrupo());

		mav.addObject("listaGrupo", grupoRest.consultaGrupo(sesionPersona.getcToken()));
		mav.addObject("habilitaboton", sesionPersona.getiIDTipoPersona() == 1 ? false:true	);
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;

	}
	
	@GetMapping("/catalogo/grupo/consulta/detalle")
	public ModelAndView consultaDetalle(@ModelAttribute("Persona") Usuario sesionPersona,
			@ModelAttribute("iGrupo") Integer iGrupo) {

		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getControlgrupodetalle());
		
		Grupo opGrupo = grupoRest.consultaUnGrupo(sesionPersona.getcToken(), 1, iGrupo);
		
		Carrera[] carreraList = carreraRest.consultaCarrera(sesionPersona.getcToken(), 1);
		
		if(carreraRest.islResultado()) {
			mav.addObject("error", carreraRest.getMensaje());
			return mav;
		}
		
		Periodo[] periodoList = periodoRest.consultaPeriodoCarrera(sesionPersona.getcToken(), 1, opGrupo.getiCarrera());
		
		if(periodoRest.islResultado()) {
			mav.addObject("error", periodoRest.getMensaje());
			return mav;
		}
		
		GrupoDetalle[] grupoList = grupoRest.consultaGrupoDetalle(sesionPersona.getcToken(), 1, opGrupo.getiGrupo());
		
		if(grupoRest.islResultado()) {
			mav.addObject("error", grupoRest.getMensaje());
			return mav;
		} else if(grupoList.length < 1) {
			mav.addObject("error", MensajeError.getError2());
		}

		mav.addObject("opGrupo", opGrupo);
		mav.addObject("carreras", carreraList);
		mav.addObject("periodos", periodoList);
		mav.addObject("listaGrupoDetalle", grupoList);
		mav.addObject("consultaListaAlumnos", true	);
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;

	}
	
	@GetMapping("/catalogo/grupo/genera-lista-pdf")
	public ResponseEntity<InputStreamResource> reporteListaPDF(@ModelAttribute("Persona") Usuario sesionPersona,
			@ModelAttribute("iGrupo") Integer iGrupo) {
		
		Grupo opGrupo = grupoRest.consultaUnGrupo(sesionPersona.getcToken(), 1, iGrupo);
		
		Alumno[] listaAlumnos = grupoRest.consultaAlumnosGrupo(sesionPersona.getcToken(), 1, opGrupo.getiGrupo());

		if(!grupoRest.islResultado()) {
			
			ByteArrayInputStream bis = GeneraKardexPDF.reporteListaAlumnos(opGrupo, listaAlumnos);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=lista-" + opGrupo.getcGrupo() + ".pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
			
		} else {
			return null;
		}		

	}
	
}