package com.sorjuana.escuela.controlador.controlalumno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class alumno {

		
			@GetMapping("/controlalumno")
			public String menu() {
				return "controlalum";
			}
}

		