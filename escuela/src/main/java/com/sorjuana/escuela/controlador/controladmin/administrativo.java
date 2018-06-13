package com.sorjuana.escuela.controlador.controladmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Admin;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;
import com.sorjuana.escuela.repositorio.tipopersona.TipoPersonaRest;



@Controller
@SessionAttributes("Persona")
public class administrativo {
	
	@Autowired
	private MenuRest menuRest;
	
	@Autowired
	private TipoPersonaRest tipoPersonaRest;
		
			@GetMapping("/catalogo/admin/inserta")
			public ModelAndView inserta(@ModelAttribute("Persona") Usuario sesionPersona) {
				
				DosParametrosEnteros consulta = new DosParametrosEnteros();
				consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
				consulta.setParametro2(sesionPersona.getiIDTipoPersona());
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName(Vistas.getFormularioadmin());
				mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
				mav.addObject("iTipoConsulta", 1);
				mav.addObject("cFormulario", "administrativo");
				
				return mav;
			}
			
			@GetMapping("/catalogo/administrativo")
			public ModelAndView menu(@ModelAttribute("Persona") Usuario sesionPersona) {
				DosParametrosEnteros consulta = new DosParametrosEnteros();
				consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
				consulta.setParametro2(sesionPersona.getiIDTipoPersona());
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName(Vistas.getControladmin());
				mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
				return mav;
			}
			
			@PostMapping("/catalogo/administrativo/inserta")	
			public @ResponseBody String inserta(@ModelAttribute("Persona") Usuario sesionPersona,
					@ModelAttribute("objPersona") String objPersona, @ModelAttribute("arrayAtributo") String arrayAtributo) {
				
				tipoPersonaRest.insertaTipoPersona(objPersona, arrayAtributo, sesionPersona.getcToken());
				
				if (tipoPersonaRest.islResultado()) {
					return tipoPersonaRest.getMensaje();
				}
				
				return "sucess";
			}
}