package com.sorjuana.escuela.controlador.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Menu {
	
	@GetMapping("/menu")
	public String menu() {
		return "prueba";
	}

}

