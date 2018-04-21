package com.sorjuana.escuela.repositorio.seg;

import com.sorjuana.escuela.modelo.Persona;

public interface LoginRep {
	
	public void validaUsuario(String usuario, String contrasena);
	public boolean islResultado();
	public String getMensaje();
	public Persona getPersona();

}
