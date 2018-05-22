package com.sorjuana.escuela.controlador.kardex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;


@Controller
@SessionAttributes("Persona")
public class Kardex {

	@Autowired
	private MenuRest menuRest;

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
			@ModelAttribute("elementoBusqueda") String elementoBusqueda) {
		System.out.print(elementoBusqueda);
		return "";
	}

}
