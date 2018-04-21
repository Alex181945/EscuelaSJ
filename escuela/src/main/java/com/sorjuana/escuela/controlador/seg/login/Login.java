package com.sorjuana.escuela.controlador.seg.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.repositorio.seg.LoginRep;

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
	
	@Autowired
	private LoginRep loginRep;
	
	@GetMapping("/")
	public String redirectLogin() {
		return Vistas.getRedirectLogin();
	}
	
	@GetMapping("/login")
	public String login() {
		return Vistas.getLogin();
	}
	
	@PostMapping("/validausuario")
	public String validaUsuario(@ModelAttribute("username") String cUsuario,
			@ModelAttribute("password") String cPassword, Model model, HttpServletRequest request) {
		
		loginRep.validaUsuario(cUsuario, cPassword);
		
		if(loginRep.islResultado()) {
			model.addAttribute("error", loginRep.getMensaje());
			return Vistas.getLogin();
		}else {
			request.getSession().setAttribute("Persona", loginRep.getPersona());
		}
		
		return Vistas.getRedirectMenuprincipal();
	}

}
