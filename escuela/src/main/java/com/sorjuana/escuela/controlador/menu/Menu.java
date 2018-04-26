package com.sorjuana.escuela.controlador.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("Persona")
public class Menu {
	
	@GetMapping("/menu")
	public ModelAndView menu() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("prueba");
		mav.addObject("menu", true);
		return mav;
	}

}

