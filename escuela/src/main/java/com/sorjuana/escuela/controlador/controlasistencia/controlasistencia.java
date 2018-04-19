package com.sorjuana.escuela.controlador.controlasistencia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sorjuana.escuela.configuracion.Vistas;

@Controller
public class controlasistencia {
	
	@GetMapping("/controlasistencia")
	public String menu() {
		return Vistas.getControlasistencia();
	}

	
}
