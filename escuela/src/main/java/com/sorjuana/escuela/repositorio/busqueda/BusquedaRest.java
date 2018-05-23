package com.sorjuana.escuela.repositorio.busqueda;

import com.sorjuana.escuela.modelo.ct.Alumno;

public interface BusquedaRest {
	
	public Alumno[] busquedaAlumno(String elementoBusqueda, String cToken);
	public boolean islResultado();
	public String getMensaje();

}
