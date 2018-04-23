package com.sorjuana.escuela.modelo.datos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 29/03/2018
 * Descripcion: Clase para la validacion de datos api rest
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Validacion {
	
	private Integer lError;
	private String cSqlState;
	private String cError;
	
	public Integer getlError() {
		return lError;
	}
	public void setlError(Integer lError) {
		this.lError = lError;
	}
	public String getcSqlState() {
		return cSqlState;
	}
	public void setcSqlState(String cSqlState) {
		this.cSqlState = cSqlState;
	}
	public String getcError() {
		return cError;
	}
	public void setcError(String cError) {
		this.cError = cError;
	}
}
