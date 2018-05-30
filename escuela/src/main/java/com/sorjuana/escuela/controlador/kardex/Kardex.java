package com.sorjuana.escuela.controlador.kardex;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Alumno;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.busqueda.BusquedaRest;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;


@Controller
@SessionAttributes("Persona")
public class Kardex {

	@Autowired
	private MenuRest menuRest;
	
	@Autowired
	private BusquedaRest busquedaRest;

	@GetMapping("/historial/alumno/calificaciones")
	public ModelAndView consulta(@ModelAttribute("Persona") Usuario sesionPersona) {
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormulariokardex());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;
	}

	@PostMapping("/historial/alumno/busqueda")
	public @ResponseBody String busqueda(@ModelAttribute("Persona") Usuario sesionPersona,
			@ModelAttribute("tipoBusqueda") String tipoBusqueda,
			@ModelAttribute("elementoBusqueda") String elementoBusqueda) {
			
		Alumno[] alumno =  busquedaRest.busquedaAlumno(tipoBusqueda, elementoBusqueda, sesionPersona.getcToken());  
		
		if(alumno != null) {
			return new Gson().toJson(alumno);
		}
		
		return "";
	}

	@GetMapping("/historial/alumno/genera")
	public ModelAndView muestraKardex(@ModelAttribute("Persona") Usuario sesionPersona, 
			@ModelAttribute("iPersona") Integer iPersona, @ModelAttribute("cNombre") String cNombre) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getHistorialkardex());
		mav.addObject("kardex", busquedaRest.generaKardex(iPersona, sesionPersona.getcToken()));
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		mav.addObject("nombre", cNombre);
		mav.addObject("iPersona", iPersona);
		
		return mav;
	}

	@GetMapping("/historial/alumno/genera-pdf")
	public ResponseEntity<InputStreamResource> reporteKardex(@ModelAttribute("Persona") Usuario sesionPersona, 
			@ModelAttribute("iPersona") Integer iPersona, @ModelAttribute("cNombre") String cNombre){
		
		ByteArrayInputStream bis = GeneraKardexPDF.reporteKardex(busquedaRest.generaKardex(iPersona, sesionPersona.getcToken()), cNombre);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=kardex-" + "" + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
		
	}
}
