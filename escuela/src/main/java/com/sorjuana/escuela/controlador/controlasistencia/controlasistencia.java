package com.sorjuana.escuela.controlador.controlasistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Asistencia;
import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.repositorio.modulo.MenuRest;


@Controller
@SessionAttributes("Persona")
public class controlasistencia {
	
	@Autowired
	private MenuRest menuRest;
	
	@GetMapping("/catalogo/asistencia/inserta")
	public ModelAndView inserta(@ModelAttribute("Persona") Usuario sesionPersona) {
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormularioasistencia());
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;
	}
	
	@GetMapping("/controlasistencia")
	public ModelAndView menu(@ModelAttribute("Persona") Usuario sesionPersona) {
		
		DosParametrosEnteros consulta = new DosParametrosEnteros();
		consulta.setParametro1(1); // Tipo de Consulta 0 inactivos, 1 activos, 2 ambos
		consulta.setParametro2(sesionPersona.getiIDTipoPersona());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getControlasistencia());
		Asistencia as = new Asistencia();
		as.setiPersona(1);
		as.setiNumEmp(15974669);
		as.setcNombre("Felipe");
		as.setcAPaterno("Chavez");
		as.setcAMaterno("Ortega");
		as.setcPer("Docente");
		as.setcHorCu("45 horas");
		as.setcObs("1 Falta // 2 Retardos");
		as.setlActivo(1);
		
		Asistencia[] asi = {as};

		mav.addObject("controlasis", asi);
		mav.addObject("menu", menuRest.cargaMenu(consulta, sesionPersona.getcToken()));
		return mav;
	}

	
}
