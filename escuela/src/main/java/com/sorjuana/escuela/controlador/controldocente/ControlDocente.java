package com.sorjuana.escuela.controlador.controldocente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControlDocente {
	
		@GetMapping("/controldocente")
		public String menu() {
			return "controld";
		}

	}


