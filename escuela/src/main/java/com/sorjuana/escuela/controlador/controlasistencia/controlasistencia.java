package com.sorjuana.escuela.controlador.controlasistencia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.ct.Asistencia;


@Controller
@SessionAttributes("Persona")
public class controlasistencia {
	
	@GetMapping("/catalogo/asistencia/inserta")
	public ModelAndView inserta() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(Vistas.getFormularioasistencia());
		mav.addObject("menu", true);
		return mav;
	}
	
	@GetMapping("/controlasistencia")
	public ModelAndView menu() {
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
		mav.addObject("menu", true);
		return mav;
	}

	
}
