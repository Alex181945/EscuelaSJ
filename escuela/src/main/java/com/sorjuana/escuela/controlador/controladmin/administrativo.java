package com.sorjuana.escuela.controlador.controladmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Admin;
import com.sorjuana.escuela.modelo.ct.CtPersona;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;



@Controller
@SessionAttributes("Persona")
public class administrativo {
	
	@Autowired
	private MenuRest menuRest;
		
			@GetMapping("/catalogo/admin/inserta")
			public ModelAndView inserta(@ModelAttribute("Persona") Usuario sesionPersona) {
				
				DosParametrosEnteros consulta = new DosParametrosEnteros();
				consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
				consulta.setParametro2(sesionPersona.getiIDTipoPersona());
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName(Vistas.getFormularioadmin());
				mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
				mav.addObject("objCtPersona", new CtPersona());
				return mav;
			}
			
			@GetMapping("/catalogo/administrativo")
			public ModelAndView menu(@ModelAttribute("Persona") Usuario sesionPersona) {
				DosParametrosEnteros consulta = new DosParametrosEnteros();
				consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
				consulta.setParametro2(sesionPersona.getiIDTipoPersona());
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName(Vistas.getControladmin());
				Admin ad = new Admin();
				ad.setiPersona(1);
				ad.setcNumEm("8952325");
				ad.setcNombre("Ruben");
				ad.setcAPaterno("Hernandez");
				ad.setcAMaterno("Aguilar");
				ad.setcFecIng("12/12/2006");
				ad.setcArea("Administrativo");
				ad.setcTel("57-98-51-23");
				ad.setcTelCel("55-89-69-74-21");
				ad.setcEmail("cdvcv@gmail.com");
				ad.setlActivo(1);
				Admin[] adm = {ad};
				
				mav.addObject("controladmin", adm);
				mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
				return mav;
			}
}