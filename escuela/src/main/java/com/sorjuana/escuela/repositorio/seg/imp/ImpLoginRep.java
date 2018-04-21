package com.sorjuana.escuela.repositorio.seg.imp;

import java.sql.*;
import java.util.logging.Logger;

import com.sorjuana.escuela.configuracion.ConexionBD;
import com.sorjuana.escuela.modelo.Persona;
import com.sorjuana.escuela.repositorio.seg.LoginRep;

public class ImpLoginRep implements LoginRep {
	
	private final static Logger LOGGER = Logger.getLogger(ImpLoginRep.class.getName());
	private Boolean resultadoLocal;
	private String  mensajeLocal;
	private Persona personaLocal;

	@Override
	public void validaUsuario(String usuario, String contrasena) {
		
		ConexionBD conexion = new ConexionBD();
		Connection inicio = conexion.GetConnection();
		
		try {
			
			Statement consulta = inicio.createStatement();
			
			ResultSet res = consulta.executeQuery("SELECT * FROM cliente WHERE cUsuario = '" + usuario
					+ "' AND cPassword = '" + contrasena + "'");
			
		} catch (SQLException e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: SQLException en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return;
		}
		
	}

	@Override
	public boolean islResultado() {
		return this.getResultadoLocal();
	}

	@Override
	public String getMensaje() {
		return this.getMensajeLocal();
	}
	
	public Boolean getResultadoLocal() {
		return resultadoLocal;
	}
	
	public void setResultadoLocal(Boolean resultado) {
		resultadoLocal = resultado;
	}
	
	public String getMensajeLocal() {
		return mensajeLocal;
	}
	
	public void setMensajeLocal(String mensaje) {
		mensajeLocal = mensaje;
	}

	
	public Persona getPersona() {
		return personaLocal;
	}
	

	public void setPersona(Persona persona) {
		this.personaLocal = persona;
	}

}
