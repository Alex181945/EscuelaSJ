package com.sorjuana.escuela.controlador.controladmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class administrativo {
		
			@GetMapping("/controladmin")
			public String menu() {
				return "controladmin";
			}
}