package com.sorjuana.escuela.repositorio.tipopersona;

public interface TipoPersonaRest {
	
	public void insertaTipoPersona(String objCtPersona, String arrayCtPersona, String cToken);
	public boolean islResultado();
	public String getMensaje();

}
