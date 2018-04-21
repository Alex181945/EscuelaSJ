package com.sorjuana.escuela.modelo;

public class Persona {

	private Integer iPersona;
	private Integer iIDPersona;
	private String  cNombre;
	private String  cAPaterno;
	private String  cAMaterno;
	private Integer lGenero;
	private String  dtFechaNac;
	private Integer lActivo;
	private String  dtCreado;
	private String  dtModificado;
	
	public Integer getiPersona() {
		return iPersona;
	}
	public void setiPersona(Integer iPersona) {
		this.iPersona = iPersona;
	}
	public Integer getiIDPersona() {
		return iIDPersona;
	}
	public void setiIDPersona(Integer iIDPersona) {
		this.iIDPersona = iIDPersona;
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

}
