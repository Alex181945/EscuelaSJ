package com.sorjuana.escuela.controlador.controlcarrera;

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
import com.sorjuana.escuela.repositorio.tipopersona.TipoPersonaRest;



@Controller
@SessionAttributes("Persona")
public class Controlcarrera {
	
	@Autowired
	private MenuRest menuRest;

	@Autowired
	private TipoPersonaRest tipoPersonaRest; 
	
	@Autowired
	private CarreraRest carreraRest;

	@GetMapping("/catalogo/carrera/consulta")
	public ModelAndView inserta(@ModelAttribute("Persona") Usuario sesionPersona) {
		return cargaDatos(sesionPersona, "", "");
	}

	@PostMapping("/catalogo/carrera/inserta")
	public @ResponseBody String inserta(@ModelAttribute("Persona") Usuario sesionPersona,
			@ModelAttribute("objPersona") String objPersona, @ModelAttribute("arrayAtributo") String arrayAtributo) {

		tipoPersonaRest.insertaTipoPersona(objPersona, arrayAtributo, sesionPersona.getcToken());

		if (tipoPersonaRest.islResultado()) {
			return tipoPersonaRest.getMensaje();
		}

		return "sucess";
	}

	@GetMapping("/catalogo/carrera/consulta/uno")
	public ModelAndView cargaRegistro(@ModelAttribute("Persona") Usuario sesionPersona,
			@ModelAttribute("iIDAdministrativo") Integer iIDAdmin) {
		
		System.out.println(iIDAdmin);

		ModelAndView mav = new ModelAndView();

		return mav;

	}	
	
	@GetMapping("/catalogo/carrera/consulta/formulario")
	public ModelAndView cargaCarrera(@ModelAttribute("Persona") Usuario sesionPersona) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormulariocarrera());
		mav.addObject("objCarrera", new Carrera());

		return mav;

	}	
	public ModelAndView cargaDatos(@ModelAttribute("Persona") Usuario sessionUsu, String mensajeExito,
			String mensajeError) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); //Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sessionUsu.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getControlcarrera());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sessionUsu.getcToken()));
		mav.addObject("carrera", carreraRest.consultaCarrera(sessionUsu.getcToken()));
		
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