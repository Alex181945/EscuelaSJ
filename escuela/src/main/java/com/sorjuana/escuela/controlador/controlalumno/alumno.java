package com.sorjuana.escuela.controlador.controlalumno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
@Controller
@SessionAttributes("Persona")
public class alumno {

		
			@GetMapping("/controlalumno")
			public ModelAndView menu() {
				ModelAndView mav = new ModelAndView();
				mav.setViewName(Vistas.getControlalumno());
				mav.addObject("menu", true);
				return mav;
			}
}

		