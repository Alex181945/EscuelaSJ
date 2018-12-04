package com.sorjuana.escuela.controlador.controlCarrera;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Carrera;
import com.sorjuana.escuela.modelo.ct.Periodo;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.carrera.CarreraRest;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;
import com.sorjuana.escuela.repositorio.periodo.PeriodoRest;

@Controller
@SessionAttributes("Persona")
public class ControlCarrera {
	
	@Autowired
	private MenuRest menuRest;
	
	@Autowired
	private CarreraRest carreraRest;
	
	@Autowired
	private PeriodoRest periodoRest;
	
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
	
	@GetMapping("/catalogo/carrera/consulta/uno")
	public ModelAndView consultaUno(@ModelAttribute("Persona") Usuario sesionPersona, @ModelAttribute("iCarrera") Integer iCarrera) {

		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormualriocarrera());
		
		Carrera objCarrera = carreraRest.consultaCarreraUno(sesionPersona.getcToken(), iCarrera);
		Periodo[] arrayPeriodo = periodoRest.consultaPeriodoCarrera(sesionPersona.getcToken(), 1, objCarrera.getiCarrera()); 

		mav.addObject("objCarrera", objCarrera);
		mav.addObject("arrayPeriodo", arrayPeriodo);
		mav.addObject("lInserta", false);
		mav.addObject("carreraActualiza", "/catalogo/carrera/actualiza");
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;

	}
	
	@PostMapping("/catalogo/carrera/inserta")
	public @ResponseBody String insertaCarrera(@ModelAttribute("Persona") Usuario sesionPersona,
			@ModelAttribute("objCarrera") String objCarreraS, @ModelAttribute("arrayPeriodo") String arrayAtributoS) {
		
		ObjectMapper mapper = new ObjectMapper();
		Carrera objCarrera = new Carrera();
		Periodo[] listPeriodo = null;
		try {
			objCarrera = mapper.readValue(objCarreraS, Carrera.class);
			listPeriodo = mapper.readValue(arrayAtributoS, Periodo[].class);
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
		carreraRest.insertaCarrera(sesionPersona.getcToken(), objCarrera);
		
		if(carreraRest.islResultado()) {			
			return carreraRest.getMensaje();
		} else {
			for (Periodo periodo : listPeriodo) {
				periodo.setiCarrera(objCarrera.getiCarrera());
				periodoRest.insertaPeriodo(sesionPersona.getcToken(), periodo);
				
				if(periodoRest.islResultado()) {
					return periodoRest.getMensaje();
				}
			}
		} 
		
		return "sucess";
	}
	
	@PostMapping("/catalogo/carrera/actualiza")
	public @ResponseBody String edita(@ModelAttribute("Persona") Usuario sesionPersona,
			@ModelAttribute("objCarrera") String objCarreraS, @ModelAttribute("arrayPeriodo") String arrayAtributoS) {
		
		ObjectMapper mapper = new ObjectMapper();
		Carrera objCarrera = new Carrera();
		Periodo[] listPeriodo = null;
		try {
			objCarreraS = objCarreraS.replace("on", "1");
			objCarrera = mapper.readValue(objCarreraS, Carrera.class);
			listPeriodo = mapper.readValue(arrayAtributoS, Periodo[].class);
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
		carreraRest.actualizaCarrera(sesionPersona.getcToken(), objCarrera);
		
		if(carreraRest.islResultado()) {			
			return carreraRest.getMensaje();
		} else {
			for (Periodo periodo : listPeriodo) {
				periodoRest.actualizaPeriodo(sesionPersona.getcToken(), periodo);
				
				if(periodoRest.islResultado()) {
					return periodoRest.getMensaje();
				}
			}
		} 
		
		return "sucess";
		
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
	
	public ModelAndView cargaDatos(@ModelAttribute("Persona") Usuario sesionPersona, String mensajeExito,
			String mensajeError) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getConsultaomateria());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		mav.addObject("controlMateria", carreraRest.consultaCarrera(sesionPersona.getcToken(), 1));
		
		/*Consulta los registros de catalogo*/
		if (carreraRest.islResultado()) {
			mav.addObject("error", carreraRest.getMensaje());
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
