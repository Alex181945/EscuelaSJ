package com.sorjuana.escuela.modelo.seg;

public class Usuario {
	
	private Integer iPersona;
	private String  cToken;
	private String  cEmail;
	private String  cContrasena;
	private Integer lActivo;
	private String  dtCreado;
	private String  dtModificado;
	
	public Integer getiPersona() {
		return iPersona;
	}
	public void setiPersona(Integer iPersona) {
		this.iPersona = iPersona;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcContrasena() {
		return cContrasena;
	}
	public void setcContrasena(String cContrasena) {
		this.cContrasena = cContrasena;
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
	public String getcToken() {
		return cToken;
	}
	public void setcToken(String cToken) {
		this.cToken = cToken;
	}
}
