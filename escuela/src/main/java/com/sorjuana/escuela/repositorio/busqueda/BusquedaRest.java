package com.sorjuana.escuela.repositorio.busqueda;

import com.sorjuana.escuela.modelo.ct.Alumno;
import com.sorjuana.escuela.modelo.datos.kardex.KardexM;

public interface BusquedaRest {
	
	public Alumno[] busquedaAlumno(String tipoBusqueda, String elementoBusqueda, String cToken);
	public KardexM[] generaKardex(Integer iPersona, String cToken);
	public boolean islResultado();
	public String getMensaje();

}
