package com.sorjuana.escuela.modelo.ct;

public class Asistencia {
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
	
	private Integer iNumEmp;
	private String cNomTra;
	private String cPer;
	private String cHorCu;
	private String cObs;
	
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
	public Integer getiNumEmp() {
		return iNumEmp;
	}
	public void setiNumEmp(Integer iNumEmp) {
		this.iNumEmp = iNumEmp;
	}
	public String getcNomTra() {
		cNomTra = cNombre + " " + cAPaterno + " " + cAMaterno;
		return cNomTra;
	}
	public void setcNomTra(String cNomTra) {
		this.cNomTra = cNomTra;
	}
	public String getcPer() {
		return cPer;
	}
	public void setcPer(String cPer) {
		this.cPer = cPer;
	}
	public String getcHorCu() {
		return cHorCu;
	}
	public void setcHorCu(String cHorCu) {
		this.cHorCu = cHorCu;
	}
	public String getcObs() {
		return cObs;
	}
	public void setcObs(String cObs) {
		this.cObs = cObs;
	}

}
