package com.sorjuana.escuela.modelo.ct;

public class Materia {
	
	private Integer iMateria;
	private String cMateria;
	private Integer iCarrera;
	private Integer iPeriodo;
	private Integer lActivo;
	private String dtCreado;
	
	public Integer getiMateria() {
		return iMateria;
	}
	public void setiMateria(Integer iMateria) {
		this.iMateria = iMateria;
	}
	public String getcMateria() {
		return cMateria;
	}
	public void setcMateria(String cMateria) {
		this.cMateria = cMateria;
	}
	public Integer getiCarrera() {
		return iCarrera;
	}
	public void setiCarrera(Integer iCarrera) {
		this.iCarrera = iCarrera;
	}
	public Integer getiPeriodo() {
		return iPeriodo;
	}
	public void setiPeriodo(Integer iPeriodo) {
		this.iPeriodo = iPeriodo;
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
	
}
