package com.sorjuana.escuela.repositorio.seg.login.imp;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorjuana.escuela.configuracion.VariablesEntorno;
import com.sorjuana.escuela.modelo.datos.Validacion;
import com.sorjuana.escuela.modelo.seg.Usuario;
import com.sorjuana.escuela.modelo.seg.UsuarioTemp;
import com.sorjuana.escuela.repositorio.seg.login.LoginRest;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 13/03/2018
 * Descripcion: Implementacion de Interfaz de Login Rest
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

@Component
public class ImpLoginRest implements LoginRest {
	
	private Boolean resultadoLocal;
	private String  mensajeLocal;
	private Usuario usuario;

	@Override
	public void validaUsuario(UsuarioTemp objUsuario) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		Validacion[] validacion = null;
		Usuario[] usuario = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;
		JsonNode validacionJs = null;
		JsonNode datos = null;
		JsonNode token = null;
		
		try {
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.postForEntity(VariablesEntorno.getUrlwsp() + "validausuario",
					objUsuario, String.class);
			
			root = mapper.readTree(response.getBody());
			validacionJs = root.path("validacion");
			datos = root.path("datos");
			token = root.path("token");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
			} else {
				usuario = mapper.convertValue(datos, Usuario[].class);
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
				this.setUsuario(usuario, token.asText());
			}
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: JsonProcessingException en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return;
		} catch (IOException e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: IOException en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return;
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return;
		}		
		
	}
	
	@Override
	public Usuario getPersona() {
		// TODO Auto-generated method stub
		return this.getPersona();
	}
	
	@Override
	public boolean islResultado() {
		// TODO Auto-generated method stub
		return this.getResultadoLocal();
	}

	@Override
	public String getMensaje() {
		// TODO Auto-generated method stub
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario[] usuario, String cToken) {
		
		Usuario usuarioLocal = new Usuario();
		usuarioLocal.setiPersona(usuario[0].getiPersona());
		usuarioLocal.setcToken(cToken);
		usuarioLocal.setcEmail(usuario[0].getcEmail());
		usuarioLocal.setcContrasena(usuario[0].getcContrasena());
		usuarioLocal.setlActivo(usuario[0].getlActivo());
		usuarioLocal.setDtCreado(usuario[0].getDtCreado());
		usuarioLocal.setDtModificado(usuario[0].getDtModificado());
		
		this.usuario = usuarioLocal;
	}
	
}