package com.sorjuana.escuela.repositorio.tipopersona;

import com.sorjuana.escuela.modelo.ct.CtPersona;

public interface TipoPersonaRest {
	
	public void insertaTipoPersona(String objCtPersona, String arrayCtPersona, String cToken);
	public CtPersona[] consultaTipoPersona(Integer tipoPersona, String cToken);
	public boolean islResultado();
	public String getMensaje();

}
