package com.sorjuana.escuela.controlador.controlalumno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sorjuana.escuela.configuracion.Vistas;
@Controller
@SessionAttributes("Persona")
public class alumno {

		
			@GetMapping("/controlalumno")
			public String menu() {
				return Vistas.getControlalumno();
			}
}

		