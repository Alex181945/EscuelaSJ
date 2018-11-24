package com.sorjuana.escuela.repositorio.materia;

import com.sorjuana.escuela.modelo.ct.Materia;

public interface MateriaRest {

	public Materia[] consultaMateria(String cToken, Integer idTipoConsulta);
	public boolean islResultado();
	public String getMensaje();
	
}
