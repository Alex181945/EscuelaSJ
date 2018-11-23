package com.sorjuana.escuela.controlador.controlmateria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.carrera.CarreraRest;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;
import com.sorjuana.escuela.repositorio.periodo.PeriodoRest;


@Controller
@SessionAttributes("Persona")
public class controlmateria {
	
	@Autowired
	private MenuRest menuRest;
	
	@Autowired
	private CarreraRest carreraRest;
	
	@Autowired
	private PeriodoRest periodoRest;
	
	@GetMapping("/catalogo/materia")
	public ModelAndView inserta(@ModelAttribute("Persona") Usuario sesionPersona) {
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getConsultaomateria());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		mav.addObject("listaCarrera",carreraRest.consultaCarrera(sesionPersona.getcToken(), 1));
		mav.addObject("srvsolicitado",periodoRest.consultaPeriodoSinCarrera(sesionPersona.getcToken(), 1));
		return mav;
	}
	

	@GetMapping("/catalogo/materia/consulta")
	public ModelAndView menu(@ModelAttribute("Persona") Usuario sesionPersona) {

		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormulariomateria());
		/*Materia mat = new Materia();
		mat.setiPersona(1);
		mat.setcClave("CD155FV845");
		mat.setcNivEdu("Primaria");
		mat.setcPeriodo("1ro");
		mat.setcMateria("Español");
		mat.setcProf("Alejandro Mares");
		mat.setlActivo(1);
		Materia[] al = { mat };

		mav.addObject("controlalum", al);*/
		mav.addObject("listaCarrera",carreraRest.consultaCarrera(sesionPersona.getcToken(), 1));
		mav.addObject("srvsolicitado",periodoRest.consultaPeriodoSinCarrera(sesionPersona.getcToken(), 1));
		mav.addObject("habilitaboton", sesionPersona.getiIDTipoPersona() == 1 ? false:true	);
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;

	}
}