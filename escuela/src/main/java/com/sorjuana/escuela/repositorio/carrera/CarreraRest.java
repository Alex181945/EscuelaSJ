package com.sorjuana.escuela.repositorio.carrera;

import com.sorjuana.escuela.modelo.ct.Carrera;

public interface CarreraRest {

	public Carrera[] consultaCarrera(String cToken);
	public boolean islResultado();
	public String getMensaje();
	
}