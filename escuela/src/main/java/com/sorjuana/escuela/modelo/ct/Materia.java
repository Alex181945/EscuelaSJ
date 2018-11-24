package com.sorjuana.escuela.modelo.ct;

public class Materia {
	
	private Integer iMateria;
	private String cMateria;
	private String cClaveSEP;
	private Integer iCarrera;
	private String cCarrera;
	private Integer iPeriodo;
	private String cPeriodo;
	private Integer lActivo;
	private String dtCreado;
	private String dtModificado;
	
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
	public String getcClaveSEP() {
		return cClaveSEP;
	}
	public void setcClaveSEP(String cClaveSEP) {
		this.cClaveSEP = cClaveSEP;
	}
	public Integer getiCarrera() {
		return iCarrera;
	}
	public void setiCarrera(Integer iCarrera) {
		this.iCarrera = iCarrera;
	}
	public String getcCarrera() {
		return cCarrera;
	}
	public void setcCarrera(String cCarrera) {
		this.cCarrera = cCarrera;
	}
	public Integer getiPeriodo() {
		return iPeriodo;
	}
	public void setiPeriodo(Integer iPeriodo) {
		this.iPeriodo = iPeriodo;
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
	
	public static Materia[] materiaDefault() {
		
		Materia materia = new Materia();
		
		materia.setiMateria(0);
		materia.setcMateria("N/A");
		materia.setcClaveSEP("N/A");
		materia.setiCarrera(0);
		materia.setcCarrera("N/A");
		materia.setiPeriodo(0);
		materia.setcPeriodo("N/A");
		materia.setlActivo(0);
		materia.setDtCreado("N/A");
		materia.setDtModificado("N/A");
		
		Materia[] materiaDefault = {materia};
		
		return materiaDefault;
	}
	
}
