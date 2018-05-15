package com.sorjuana.escuela.controlador.controladmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Admin;



@Controller
@SessionAttributes("Persona")
public class administrativo {
		
			/*@GetMapping("/controladmin")
			public ModelAndView menu() {
				ModelAndView mav = new ModelAndView();
				mav.setViewName(Vistas.getControladmin());
				mav.addObject("menu", true);
				return mav;
			}*/
			
			@GetMapping("/controladmin")
			public ModelAndView menu() {
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
				Admin[] adm = {ad};
				
				mav.addObject("controladmin", adm);
				mav.addObject("menu", true);
				return mav;
			}
}