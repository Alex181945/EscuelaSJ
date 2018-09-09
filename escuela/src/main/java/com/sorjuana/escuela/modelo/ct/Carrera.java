package com.sorjuana.escuela.modelo.ct;

public class Carrera {
	
	private Integer iCarrera;
	private String  cCarrera;
	private Integer lActivo;
	private String dtCreado;
	private String dtModificado;
	
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
	
	public static Carrera[] carreraDefault() {
		
		Carrera carrera = new Carrera();
		
		carrera.setiCarrera(0);
		carrera.setcCarrera("N/A");
		carrera.setlActivo(0);
		carrera.setDtCreado("N/A");
		carrera.setDtModificado("N/A");
		
		Carrera[] carreraDefault = {carrera};
		
		return carreraDefault;
	}

}
