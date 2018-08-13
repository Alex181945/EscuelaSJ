package com.sorjuana.escuela.controlador.controlgrupo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;


@Controller
@SessionAttributes("Persona")
public class controlgrupo {
	
	@Autowired
	private MenuRest menuRest;
	
	@GetMapping("/catalogo/grupo/inserta")
	public ModelAndView inserta(@ModelAttribute("Persona") Usuario sesionPersona) {
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getControlgrupo());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;
	}
}