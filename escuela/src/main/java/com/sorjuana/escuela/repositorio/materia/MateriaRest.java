package com.sorjuana.escuela.repositorio.materia;

import com.sorjuana.escuela.modelo.ct.Materia;

public interface MateriaRest {

	public Materia[] consultaMateria(String cToken, Integer idTipoConsulta);
	public Materia consultaMateriaUno(String cToken, Integer iMateria);
	public void   insertaMateria(String cToken, Materia objMateria);
	public void   actualizaMateria(String cToken, Materia objMateria);
	public void   borraMateria(String cToken, Integer iMateria);
	public boolean islResultado();
	public String getMensaje();
	
}
