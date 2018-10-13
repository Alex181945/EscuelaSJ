package com.sorjuana.escuela.repositorio.grupo;

import com.sorjuana.escuela.modelo.ct.Grupo;
import com.sorjuana.escuela.modelo.ct.GrupoDetalle;

public interface GrupoRest {
	
	public Grupo[] consultaGrupo(String cToken);
	public Grupo consultaUnGrupo(String cToken, Integer iTipoConsulta, Integer iGrupo);
	public GrupoDetalle[] consultaGrupoDetalle(String cToken, Integer iTipoConsulta, Integer iGrupo);
	public boolean islResultado();
	public String getMensaje();
}
