package com.sorjuana.escuela.repositorio.busqueda;

import com.sorjuana.escuela.modelo.ct.Alumno;
import com.sorjuana.escuela.modelo.datos.kardex.Kardex;

public interface BusquedaRest {
	
	public Alumno[] busquedaAlumno(String tipoBusqueda, String elementoBusqueda, String cToken);
	public Kardex[] generaKardex(Integer iPersona, String cToken);
	public boolean islResultado();
	public String getMensaje();

}
