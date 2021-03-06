package com.sorjuana.escuela.controlador.controldocente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Docente;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;

@Controller
@SessionAttributes("Persona")
public class ControlDocente {
	
	@Autowired
	private MenuRest menuRest;
	
		@GetMapping("/catalogo/docente/inserta")
		public ModelAndView inserta(@ModelAttribute("Persona") Usuario sesionPersona) {
			DosParametrosEnteros consulta = new DosParametrosEnteros();
			consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
			consulta.setParametro2(sesionPersona.getiIDTipoPersona());
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName(Vistas.getFormulariodocente());
			mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
			return mav;
		}
		
		@GetMapping("/catalogo/docente")
		public ModelAndView menu(@ModelAttribute("Persona") Usuario sesionPersona) {
			DosParametrosEnteros consulta = new DosParametrosEnteros();
			consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
			consulta.setParametro2(sesionPersona.getiIDTipoPersona());
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName(Vistas.getControldocente());
			Docente doc = new Docente();
			doc.setiPersona(1);
			doc.setcNombre("Juan");
			doc.setcAPaterno("Estrada");
			doc.setcAMaterno("Morales");
			doc.setiNumEmp(1234);
			doc.setcCedPro("RODK152");
			doc.setcEmail("acvs@gmail.com");
			doc.setcTel("52-55-89-75");
			doc.setlGenero(0);
			doc.setlActivo(1);
			doc.setcFecIng("19/12/2000");
			
			Docente doc1 = new Docente();
			doc1.setiPersona(1);
			doc1.setcNombre("Juan");
			doc1.setcAPaterno("Estrada");
			doc1.setcAMaterno("Morales");
			doc1.setiNumEmp(1234);
			doc1.setcCedPro("RODK152");
			doc1.setcEmail("acvs@gmail.com");
			doc1.setcTel("52-55-89-75");
			doc1.setlGenero(0);
			doc1.setlActivo(1);
			doc1.setcFecIng("19/12/2000");
			Docente[] docen = {doc, doc1};

			mav.addObject("controld", docen);
			mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
			mav.addObject("habilitaboton", sesionPersona.getiIDTipoPersona() == 1 ? false : true);
			return mav;
		}
		
	}


