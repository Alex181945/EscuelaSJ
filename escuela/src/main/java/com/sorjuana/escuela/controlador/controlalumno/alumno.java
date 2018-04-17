package com.sorjuana.escuela.controlador.controlalumno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sorjuana.escuela.configuracion.Vistas;
@Controller
public class alumno {

		
			@GetMapping("/controlalumno")
			public String menu() {
				return Vistas.getControlalumno();
			}
}

		