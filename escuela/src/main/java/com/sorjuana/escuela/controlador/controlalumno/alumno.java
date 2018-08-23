package com.sorjuana.escuela.controlador.controlalumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Alumno;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;

@Controller
@SessionAttributes("Persona")
public class alumno {

	@Autowired
	private MenuRest menuRest;

	/*
	 * @GetMapping("/controlalumno") public ModelAndView menu() { ModelAndView mav =
	 * new ModelAndView(); mav.setViewName(Vistas.getControlalumno());
	 * mav.addObject("menu", true); return mav; }
	 */

	@GetMapping("/catalogo/alumno/inserta")
	public ModelAndView inserta(@ModelAttribute("Persona") Usuario sesionPersona) {
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormularioalumno());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;
	}

	@GetMapping("/catalogo/alumno")
	public ModelAndView menu(@ModelAttribute("Persona") Usuario sesionPersona) {

		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getControlalumno());
		Alumno alum = new Alumno();
		alum.setiPersona(1);
		alum.setiMatricula(1258793);
		alum.setcNombre("Luis");
		alum.setcAPaterno("Rojano");
		alum.setcAMaterno("Guzman");
		alum.setcCURP("ROGL99812");
		alum.setDtFechaNac("12/08/1999");
		alum.setlGenero(0);
		alum.setcDireccion("AV EL COYOL");
		alum.setcNumExt("#156");
		alum.setcNumInt("");
		alum.setcGrado("2do");
		alum.setcCol("PRADOS");
		alum.setcCP("78952");
		alum.setcDelMun("GAM");
		alum.setcTel("57-89-45-89");
		alum.setcTelCel("55-21-58-78-63");
		alum.setcNivEdu("Secundaria");
		alum.setcPeri("Enero-2018");
		alum.setcNomTu("JUAN ROMERO RIOS");
		alum.setcPareTu("Tio");
		alum.setcTelTu("55-89-74-89-01");
		alum.setlActivo(1);
		Alumno[] al = { alum };

		mav.addObject("controlalum", al);
		mav.addObject("habilitaboton", sesionPersona.getiIDTipoPersona() == 1 ? false:true	);
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;

	}
}
