package com.sorjuana.escuela.repositorio.grupo;

import com.sorjuana.escuela.modelo.ct.Grupo;

public interface GrupoRest {
	
	public Grupo[] consultaGrupo(String cToken);
	public boolean islResultado();
	public String getMensaje();
}
