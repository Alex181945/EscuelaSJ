package com.sorjuana.escuela.modelo.ct;

public class Periodo {

	private Integer iPeriodo;
	private Integer iCarrera;
	private String  cPeriodo;
	private Integer lActivo;
	private String dtCreado;
	private String dtModificado;
	
	public Integer getiPeriodo() {
		return iPeriodo;
	}
	public void setiPeriodo(Integer iPeriodo) {
		this.iPeriodo = iPeriodo;
	}
	public Integer getiCarrera() {
		return iCarrera;
	}
	public void setiCarrera(Integer iCarrera) {
		this.iCarrera = iCarrera;
	}
	public String getcPeriodo() {
		return cPeriodo;
	}
	public void setcPeriodo(String cPeriodo) {
		this.cPeriodo = cPeriodo;
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
	
	public static Periodo[] periodoDefault() {
		
		Periodo periodo = new Periodo();
		
		periodo.setiPeriodo(0);
		periodo.setiCarrera(0);
		periodo.setcPeriodo("N/A");
		periodo.setlActivo(0);
		periodo.setDtCreado("N/A");
		periodo.setDtModificado("N/A");
		
		Periodo[] periodoDefault = {periodo};
		
		return periodoDefault;
	}
	
}
