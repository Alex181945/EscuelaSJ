package com.sorjuana.escuela.modelo.ct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CtPersona {

	private Integer iPersona;
	private Integer iIDTipoPersona;
	private String cNombre;
	private String cAPaterno;
	private String cAMaterno;
	private String cNomCompleto;
	private Integer lGenero;
	private String dtFechaNac;
	private Integer lActivo;
	private String dtCreado;
	private String dtModificado;
	
	public Integer getiPersona() {
		return iPersona;
	}
	public void setiPersona(Integer iPersona) {
		this.iPersona = iPersona;
	}
	public Integer getiIDTipoPersona() {
		return iIDTipoPersona;
	}
	public void setiIDTipoPersona(Integer iIDTipoPersona) {
		this.iIDTipoPersona = iIDTipoPersona;
	}
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public String getcAPaterno() {
		return cAPaterno;
	}
	public void setcAPaterno(String cAPaterno) {
		this.cAPaterno = cAPaterno;
	}
	public String getcAMaterno() {
		return cAMaterno;
	}
	public void setcAMaterno(String cAMaterno) {
		this.cAMaterno = cAMaterno;
	}
	public String getcNomCompleto() {
		cNomCompleto = cNombre + " " + cAPaterno + " " + cAMaterno;
		return cNomCompleto;
	}
	public void setcNomCompleto(String cNomCompleto) {
		this.cNomCompleto = cNomCompleto;
	}
	public Integer getlGenero() {
		return lGenero;
	}
	public void setlGenero(Integer lGenero) {
		this.lGenero = lGenero;
	}
	public String getDtFechaNac() {
		return dtFechaNac;
	}
	public void setDtFechaNac(String dtFechaNac) {
		this.dtFechaNac = dtFechaNac;
	}
	public Integer getlActivo() {
		return lActivo;
	}
	public void setlActivo(Integer lActivo) {
		this.lActivo = lActivo;
	}
	public String getDtCreado() {
		return dtCreado;
	}
	public void setDtCreado(String dtCreado) {
		this.dtCreado = dtCreado;
	}
	public String getDtModificado() {
		return dtModificado;
	}
	public void setDtModificado(String dtModificado) {
		this.dtModificado = dtModificado;
	}
		
}
