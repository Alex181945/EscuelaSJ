package com.sorjuana.escuela.repositorio.carrera;

import com.sorjuana.escuela.modelo.ct.Carrera;

public interface CarreraRest {

	public Carrera[] consultaCarrera(String cToken, Integer idTipoConsulta);
	public void   insertaCarrera(String cToken, Carrera objCarrera);
	public void   actualizaCarrera(String cToken, Carrera objCarrera);
	public void borraCarrera(String cToken, Integer iCarrera);
	public boolean islResultado();
	public String getMensaje();
	
}
