package com.sorjuana.escuela.repositorio.busqueda.imp;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorjuana.escuela.configuracion.MensajeError;
import com.sorjuana.escuela.configuracion.VariablesEntorno;
import com.sorjuana.escuela.modelo.ct.Alumno;
import com.sorjuana.escuela.modelo.datos.Validacion;
import com.sorjuana.escuela.repositorio.busqueda.BusquedaRest;

public class ImpBusquedaRest implements BusquedaRest {
	
	private final static Logger LOGGER = Logger.getLogger(ImpBusquedaRest.class.getName());
	private Boolean resultadoLocal;
	private String  mensajeLocal;

	@SuppressWarnings("static-access")
	@Override
	public Alumno[] busquedaAlumno(String elementoBusqueda, String cToken) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		Alumno[]     alumno       = null;
		Validacion[] validacion   = null;
		ObjectMapper mapper       = new ObjectMapper();
		JsonNode     root         = null;
		JsonNode     validacionJs = null;
		JsonNode     datos        = null;
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(VariablesEntorno.getHeaderString(), VariablesEntorno.getTokenPrefix() + cToken);
			
			MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     
			body.add("elemenBusquedaAlumno", elementoBusqueda);

			HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);
			
			/*JSON obtenido de forma plana*/
			ResponseEntity<String> response = restTemplate.exchange(VariablesEntorno.getUrlwsd() + "/busquedas",
					HttpMethod.POST ,httpEntity, String.class);
			
			root = mapper.readTree(response.getBody());
			
			if(root.has("error")) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(MensajeError.getERROR1());
				this.LOGGER.log(Level.SEVERE,root.path("error").toString());
				return alumno;
			}
			
			validacionJs = root.path("validacion");
			datos = root.path("datos");
			
			validacion = mapper.convertValue(validacionJs, Validacion[].class);
			
			if(validacion[0].getlError() == 1) {
				this.setResultadoLocal(true);
				this.setMensajeLocal(validacion[0].getcSqlState()+" "+validacion[0].getcError());
			} else {
				alumno = mapper.convertValue(datos, Alumno[].class);
				this.setResultadoLocal(false);
				this.setMensajeLocal("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setResultadoLocal(true);
			this.setMensajeLocal("Error: Exception en " + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}

		return alumno;
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

	public void setResultadoLocal(Boolean resultadoLocal) {
		this.resultadoLocal = resultadoLocal;
	}

	public String getMensajeLocal() {
		return mensajeLocal;
	}

	public void setMensajeLocal(String mensajeLocal) {
		this.mensajeLocal = mensajeLocal;
	}

}
