package com.sorjuana.escuela.repositorio.periodo;

import com.sorjuana.escuela.modelo.ct.Periodo;

public interface PeriodoRest {
	
	public Periodo[] consultaPeriodoCarrera(String cToken, Integer iTipoConsulta, Integer iCarrera);
	public boolean islResultado();
	public String getMensaje();

}
