package com.sorjuana.escuela.repositorio.seg.imp;

import java.sql.*;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.sorjuana.escuela.configuracion.ConexionBD;
import com.sorjuana.escuela.modelo.Persona;
import com.sorjuana.escuela.repositorio.seg.LoginRep;

@Component
public class ImpLoginRep implements LoginRep {
	
	private final static Logger LOGGER = Logger.getLogger(ImpLoginRep.class.getName());
	private Boolean resultadoLocal;
	private String  mensajeLocal;
	private Persona personaLocal;

	@Override
	public void validaUsuario(String usuario, String contrasena) {
		
		System.out.println(usuario);
		System.out.println(contrasena);
		
		Connection inicio = ConexionBD.GetConnection();
		
		try {
			
			Statement consulta = inicio.createStatement();
			
			String sql = "SET @p0 = "+ usuario +"; SET @p1 = "+ contrasena +";";
		    sql += "CALL validaUsuario(@p0, @p1, @p2, @p3, @p4);";
		    sql += "SELECT @p2 AS `lError`, @p3 AS `cSqlState`, @p4 AS `cError`;";
			
		    System.out.println(sql);
		    
			ResultSet res = consulta.executeQuery(sql);
			
			System.out.println(res.toString());
			
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
