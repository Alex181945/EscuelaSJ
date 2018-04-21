package com.sorjuana.escuela.controlador.controldocente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sorjuana.escuela.configuracion.Vistas;

@Controller
public class ControlDocente {
	
		@GetMapping("/controldocente")
		public String menu() {
			return Vistas.getControldocente();
		}

	}


