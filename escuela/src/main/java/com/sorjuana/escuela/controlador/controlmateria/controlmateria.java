package com.sorjuana.escuela.controlador.controlmateria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Materia;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.carrera.CarreraRest;
import com.sorjuana.escuela.repositorio.materia.MateriaRest;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;
import com.sorjuana.escuela.repositorio.periodo.PeriodoRest;


@Controller
@SessionAttributes("Persona")
public class controlmateria {
	
	@Autowired
	private MenuRest menuRest;
	
	@Autowired
	private MateriaRest materiaRest;
	
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
		mav.addObject("controlMateria", materiaRest.consultaMateria(sesionPersona.getcToken(), 1));
		
		return mav;
	}
	

	@GetMapping("/catalogo/materia/formulario")
	public ModelAndView menu(@ModelAttribute("Persona") Usuario sesionPersona) {

		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());

		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormulariomateria());

		mav.addObject("materia", new Materia());
		mav.addObject("listaCarrera",carreraRest.consultaCarrera(sesionPersona.getcToken(), 1));
		mav.addObject("srvsolicitado",periodoRest.consultaPeriodoSinCarrera(sesionPersona.getcToken(), 1));
		mav.addObject("habilitaboton", sesionPersona.getiIDTipoPersona() == 1 ? false:true	);
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;

	}
	
	@PostMapping("/catalogo/materia/inserta")
	public ModelAndView insertaMateria(@ModelAttribute("Usuario") Usuario sesionPersona,
			@ModelAttribute("materia") Materia objMateria){
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormulariomateria());
		
		return null;
	}
	
}