package com.sorjuana.escuela.modelo.ct;

public class Admin {
	private Integer iPersona;
	private Integer iIDTipoPersona;
	private String cNombre;
	private String cAPaterno;
	private String cAMaterno;
	private Integer lGenero;
	private String dtFechaNac;
	private Integer lActivo;
	private String dtCreado;
	private String dtModificado;
	
	private String cNumEm;
	private String cNomAdm;
	private String cFecIng;	
	private String cArea;
	private String cTel;
	private String cTelCel;
	private String cEmail;
	
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
	public String getcNumEm() {
		return cNumEm;
	}
	public void setcNumEm(String i) {
		this.cNumEm = i;
	}
	public String getcNomAdm() {
		cNomAdm = cNombre + " " + cAPaterno + " " + cAMaterno;
		return cNomAdm;
	}
	public void setcNomAdm(String cNomAdm) {
		this.cNomAdm = cNomAdm;
	}
	public String getcFecIng() {
		return cFecIng;
	}
	public void setcFecIng(String cFecIng) {
		this.cFecIng = cFecIng;
	}
	public String getcArea() {
		return cArea;
	}
	public void setcArea(String cArea) {
		this.cArea = cArea;
	}
	public String getcTel() {
		return cTel;
	}
	public void setcTel(String cTel) {
		this.cTel = cTel;
	}
	public String getcTelCel() {
		return cTelCel;
	}
	public void setcTelCel(String cTelCel) {
		this.cTelCel = cTelCel;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	
	

}
