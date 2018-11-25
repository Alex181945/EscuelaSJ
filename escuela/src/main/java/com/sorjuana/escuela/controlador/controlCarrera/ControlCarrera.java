package com.sorjuana.escuela.controlador.controlCarrera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Carrera;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.carrera.CarreraRest;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;

@Controller
@SessionAttributes("Persona")
public class ControlCarrera {
	
	@Autowired
	private MenuRest menuRest;
	
	@Autowired
	private CarreraRest carreraRest;
	
	@GetMapping("/catalogo/carrera")
	public ModelAndView getListaCarrera(@ModelAttribute("Persona") Usuario sesionPersona) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(Vistas.getConsultacarrera());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		mav.addObject("controlCarrera",carreraRest.consultaCarrera(sesionPersona.getcToken(), 1));
		
		return mav;
		 
	}
	
	@GetMapping("/catalogo/carrera/formulario")
	public ModelAndView getFormulario(@ModelAttribute("Persona") Usuario sesionPersona) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(Vistas.getFormualriocarrera());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		mav.addObject("carrera", new Carrera());
		mav.addObject("lInserta", true);
		mav.addObject("carreraInserta", "/catalogo/carrera/inserta");
		
		return mav;
		
	}
	
	@PostMapping("/catalogo/carrera/borra")	
	public @ResponseBody String borra(@ModelAttribute("Persona") Usuario sessionUsu,
			@ModelAttribute("ID") Integer iCarrera) {
		
		carreraRest.borraCarrera(sessionUsu.getcToken(), iCarrera);
		
		if(carreraRest.islResultado()) {
			return carreraRest.getMensaje();
		} 
		
		return "success";
	}

}
