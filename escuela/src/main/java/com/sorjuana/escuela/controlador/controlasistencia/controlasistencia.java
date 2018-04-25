package com.sorjuana.escuela.controlador.controlasistencia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sorjuana.escuela.configuracion.Vistas;

@Controller
@SessionAttributes("Persona")
public class controlasistencia {
	
	@GetMapping("/controlasistencia")
	public String menu() {
		return Vistas.getControlasistencia();
	}

	
}
