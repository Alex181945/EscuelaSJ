package com.sorjuana.escuela.controlador.controlmateria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.MensajeExito;
import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Materia;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.carrera.CarreraRest;
import com.sorjuana.escuela.repositorio.materia.MateriaRest;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;
import com.sorjuana.escuela.repositorio.periodo.PeriodoRest;


@Controller
@SessionAttributes("Persona")
public class controlmateria {
	
	@Autowired
	private MenuRest menuRest;
	
	@Autowired
	private MateriaRest materiaRest;
	
	@Autowired
	private CarreraRest carreraRest;
	
	@Autowired
	private PeriodoRest periodoRest;
	
	@GetMapping("/catalogo/materia")
	public ModelAndView inserta(@ModelAttribute("Persona") Usuario sesionPersona) {
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getConsultaomateria());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		mav.addObject("controlMateria", materiaRest.consultaMateria(sesionPersona.getcToken(), 1));
		
		return mav;
	}
	

	@GetMapping("/catalogo/materia/formulario")
	public ModelAndView menu(@ModelAttribute("Persona") Usuario sesionPersona) {

		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormulariomateria());

		mav.addObject("materia", new Materia());
		mav.addObject("lInserta", true);
		mav.addObject("materiaInserta", "/catalogo/materia/inserta");
		mav.addObject("listaCarrera",carreraRest.consultaCarrera(sesionPersona.getcToken(), 1));
		mav.addObject("srvsolicitado",periodoRest.consultaPeriodoSinCarrera(sesionPersona.getcToken(), 1));
		mav.addObject("habilitaboton", sesionPersona.getiIDTipoPersona() == 1 ? false:true	);
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;

	}
	
	@GetMapping("/catalogo/materia/consulta/uno")
	public ModelAndView consultaUno(@ModelAttribute("Persona") Usuario sesionPersona, @ModelAttribute("iMateria") Integer iMateria) {

		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormulariomateria());

		mav.addObject("materia", materiaRest.consultaMateriaUno(sesionPersona.getcToken(), iMateria));
		mav.addObject("lInserta", false);
		mav.addObject("materiaActualiza", "/catalogo/materia/actualiza");
		mav.addObject("listaCarrera",carreraRest.consultaCarrera(sesionPersona.getcToken(), 1));
		mav.addObject("srvsolicitado",periodoRest.consultaPeriodoSinCarrera(sesionPersona.getcToken(), 1));
		mav.addObject("habilitaboton", sesionPersona.getiIDTipoPersona() == 1 ? false:true	);
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;

	}
	
	@PostMapping("/catalogo/materia/inserta")
	public ModelAndView insertaMateria(@ModelAttribute("Persona") Usuario sesionPersona,
			@ModelAttribute("materia") Materia objMateria){
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		
		materiaRest.insertaMateria(sesionPersona.getcToken(), objMateria);
		
		if(materiaRest.islResultado()) {
			mav.setViewName(Vistas.getFormulariomateria());
			mav.addObject("materia", objMateria);
			mav.addObject("lInserta", true);
			mav.addObject("materiaInserta", "/catalogo/materia/inserta");
			mav.addObject("listaCarrera",carreraRest.consultaCarrera(sesionPersona.getcToken(), 1));
			mav.addObject("srvsolicitado",periodoRest.consultaPeriodoSinCarrera(sesionPersona.getcToken(), 1));
			mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
			mav.addObject("error", materiaRest.getMensaje());
			//mav.addObject("estatusEdificioConsulta", Vistas.CT_EDIFICIO_CONSULTA_R);
		} else {
			mav = cargaDatos(sesionPersona, MensajeExito.getExitoCtMateriaInserta(), "");
		}

		return mav;
		
	}
	
	@PostMapping("/catalogo/materia/actualiza")
	public ModelAndView edita(@ModelAttribute("Persona") Usuario sessionUsu,
			@ModelAttribute("materia") Materia objMateria, 
			@ModelAttribute("activo") String lActivo) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiIDTipoPersona());

		objMateria.setlActivo(lActivo.equals("on") ? 1 : 0);
		materiaRest.actualizaMateria(sessionUsu.getcToken(), objMateria);
		ModelAndView mav = new ModelAndView();
		
		if(materiaRest.islResultado()) {
			mav.setViewName(Vistas.getFormulariomateria());
			mav.addObject("objEdificio", objMateria);
			mav.addObject("lInserta", false);
			mav.addObject("materiaActualiza", "/catalogo/materia/actualiza");
			mav.addObject("listaCarrera",carreraRest.consultaCarrera(sessionUsu.getcToken(), 1));
			mav.addObject("srvsolicitado",periodoRest.consultaPeriodoSinCarrera(sessionUsu.getcToken(), 1));
			mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
			mav.addObject("error", materiaRest.getMensaje());
		} else {
			
			mav = cargaDatos(sessionUsu, MensajeExito.getExitoCtMateriaEdita(), "");
			
		}
		
		return mav;
		
	}
	
	@PostMapping("/catalogo/materia/borra")	
	public @ResponseBody String borra(@ModelAttribute("Persona") Usuario sessionUsu,
			@ModelAttribute("ID") Integer iMateria) {
		
		materiaRest.borraMateria(sessionUsu.getcToken(), iMateria);
		
		if(materiaRest.islResultado()) {
			return materiaRest.getMensaje();
		} 
		
		return "success";
	}
	
	public ModelAndView cargaDatos(@ModelAttribute("Persona") Usuario sesionPersona, String mensajeExito,
			String mensajeError) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getConsultaomateria());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		mav.addObject("controlMateria", materiaRest.consultaMateria(sesionPersona.getcToken(), 1));
		
		/*Consulta los registros de catalogo*/
		if (materiaRest.islResultado()) {
			mav.addObject("error", materiaRest.getMensaje());
		}
				
		/*Captura y manda en caso de existir los mensajes de exito o erro*/
		if(mensajeExito != "" || mensajeExito != null) {
			mav.addObject("exito", mensajeExito);
		}
		if(mensajeError != "" || mensajeError != null) {
			mav.addObject("error", mensajeError);
		}
		
		return mav;
		
	}
	
}