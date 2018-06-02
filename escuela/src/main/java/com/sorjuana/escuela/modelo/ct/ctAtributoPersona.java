package com.sorjuana.escuela.modelo.ct;

public class ctAtributoPersona {
	
	private Integer iAtributoPer;
	private Integer iAtributo;
	private Integer iIDTipoPersona;
	private Integer iPersona;
	private String  cValor;
	private String  cObs;
	private Integer lActivo;
	private String  dtCreado;
	private String  dtModificado;
	
	public Integer getiAtributoPer() {
		return iAtributoPer;
	}
	public void setiAtributoPer(Integer iAtributoPer) {
		this.iAtributoPer = iAtributoPer;
	}
	public Integer getiAtributo() {
		return iAtributo;
	}
	public void setiAtributo(Integer iAtributo) {
		this.iAtributo = iAtributo;
	}
	public Integer getiIDTipoPersona() {
		return iIDTipoPersona;
	}
	public void setiIDTipoPersona(Integer iIDTipoPersona) {
		this.iIDTipoPersona = iIDTipoPersona;
	}
	public Integer getiPersona() {
		return iPersona;
	}
	public void setiPersona(Integer iPersona) {
		this.iPersona = iPersona;
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
