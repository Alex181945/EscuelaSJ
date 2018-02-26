package com.sorjuana.escuela.controlador.seg.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Autor: SISAEM
 * Fecha: 21 de febrero de 2017
 * Descripcion: Gestiona las peticiones hechas a la 
 * aplicacion unicamente del modulo de seguridad, desde
 * la pantalla de login
 * 
 */

@Controller
public class Login {
	
	@GetMapping("/")
	public String redirectLogin() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "index";
	}

}
