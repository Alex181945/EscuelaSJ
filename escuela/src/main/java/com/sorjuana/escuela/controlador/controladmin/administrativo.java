package com.sorjuana.escuela.controlador.controladmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sorjuana.escuela.configuracion.Vistas;

@Controller
public class administrativo {
		
			@GetMapping("/controladmin")
			public String menu() {
				return Vistas.getControladmin();
			}
}