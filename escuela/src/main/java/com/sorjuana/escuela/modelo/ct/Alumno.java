package com.sorjuana.escuela.modelo.ct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Alumno {
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
	
	private Integer iAtributo;
	private String cValor;
	private String cObs;
	private Integer iMatricula;
	private String cNomAlum;
	private String cCURP;
	private String cDireccion;
	private String cNumInt;
	private String cNumExt;
	private String cCol;
	private String cCP;
	private String cDelMun;
	private String cTel;
	private String cTelCel;
	private String cNivEdu;
	private String cGrado;
	private String cPeri;
	private String cNomTu;
	private String cPareTu;
	private String cTelTu;
	
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
	public Integer getiMatricula() {
		return iMatricula;
	}
	public void setiMatricula(Integer iMatricula) {
		this.iMatricula = iMatricula;
	}
	public String getcNomAlum() {
		cNomAlum = cNombre + " " + cAPaterno + " " + cAMaterno;
		return cNomAlum ;
	}
	public void setcNomAlum(String cNomAlum) {
		this.cNomAlum = cNombre + " " + cAPaterno + " " + cAMaterno;
	}
	public String getcCURP() {
		return cCURP;
	}
	public void setcCURP(String cCURP) {
		this.cCURP = cCURP;
	}
	public String getcDireccion() {
		cDireccion = cDireccion + " " + cNumInt + " " + cNumExt + " " + cCol + " " + cCP + " " + cDelMun;
		return cDireccion;
	}
	public void setcDireccion(String cDireccion) {
		this.cDireccion = cDireccion;
	}
	public String getcNumInt() {
		return cNumInt;
	}
	public void setcNumInt(String cNumInt) {
		this.cNumInt = cNumInt;
	}
	public String getcNumExt() {
		return cNumExt;
	}
	public void setcNumExt(String cNumExt) {
		this.cNumExt = cNumExt;
	}
	public String getcCol() {
		return cCol;
	}
	public void setcCol(String cCol) {
		this.cCol = cCol;
	}
	public String getcCP() {
		return cCP;
	}
	public void setcCP(String i) {
		this.cCP = i;
	}
	public String getcDelMun() {
		return cDelMun;
	}
	public void setcDelMun(String cDelMun) {
		this.cDelMun = cDelMun;
	}
	public String getcTel() {
		return cTel;
	}
	public void setcTel(String cTel) {
		this.cTel = cTel;
	}
	public String getcNivEdu() {
		return cNivEdu;
	}
	public void setcNivEdu(String cNivEdu) {
		this.cNivEdu = cNivEdu;
	}
	public String getcGrado() {
		return cGrado;
	}
	public void setcGrado(String cGrado) {
		this.cGrado = cGrado;
	}
	public String getcPeri() {
		return cPeri;
	}
	public void setcPeri(String cPeri) {
		this.cPeri = cPeri;
	}
	public String getcNomTu() {
		cNomTu = cNomTu + " "+ cPareTu + " " + cTelTu;
		return cNomTu;
	}
	public void setcNomTu(String cNomTu) {
		this.cNomTu = cNomTu;
	}
	public String getcPareTu() {
		return cPareTu;
	}
	public void setcPareTu(String cPareTu) {
		this.cPareTu = cPareTu;
	}
	public String getcTelTu() {
		return cTelTu;
	}
	public void setcTelTu(String cTelTu) {
		this.cTelTu = cTelTu;
	}
	public String getcTelCel() {
		return cTelCel;
	}
	public void setcTelCel(String cTelCel) {
		this.cTelCel = cTelCel;
	}
	public Integer getiAtributo() {
		return iAtributo;
	}
	public void setiAtributo(Integer iAtributo) {
		this.iAtributo = iAtributo;
	}
	public String getcValor() {
		return cValor;
	}
	public void setcValor(String cValor) {
		this.cValor = cValor;
	}
	public String getcObs() {
		return cObs;
	}
	public void setcObs(String cObs) {
		this.cObs = cObs;
	}
	public String getcNombreCompleto() {
		return cNomAlum;
	}
	
	public static Alumno[] alumnoDefault() {
		
		Alumno alumno = new Alumno();
		alumno.setcNombre("N/A");
		alumno.setcAPaterno("N/A");
		alumno.setcAMaterno("N/A");
		
		Alumno[] alumnoArray = {alumno};
		
		return alumnoArray;
		
	}
	
}
