package com.sorjuana.escuela.modelo.ct;

public class Grupo {
	
	private Integer iGrupo;
	private String  cGrupo;
	private Integer iCarrera;
	private Integer iPeriodo;
	private Integer lActivo;
	private String  dtCreado;
	private String  dtModificado;
	
	/*Campos extras a la base*/
	private String cCarrera;
	private String cPeriodo;
	
	public Integer getiGrupo() {
		return iGrupo;
	}
	public void setiGrupo(Integer iGrupo) {
		this.iGrupo = iGrupo;
	}
	public String getcGrupo() {
		return cGrupo;
	}
	public void setcGrupo(String cGrupo) {
		this.cGrupo = cGrupo;
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
	public String getDtModificado() {
		return dtModificado;
	}
	public void setDtModificado(String dtModificado) {
		this.dtModificado = dtModificado;
	}
	public String getcCarrera() {
		return cCarrera;
	}
	public void setcCarrera(String cCarrera) {
		this.cCarrera = cCarrera;
	}
	public String getcPeriodo() {
		return cPeriodo;
	}
	public void setcPeriodo(String cPeriodo) {
		this.cPeriodo = cPeriodo;
	}
	
	public static Grupo[] grupoDefault() {
		
		Grupo grupo = new Grupo();
		grupo.setiGrupo(0);
		grupo.setcGrupo("N/A");
		grupo.setiCarrera(0);
		grupo.setiPeriodo(0);
		grupo.setlActivo(0);
		grupo.setDtCreado("N/A");
		grupo.setDtModificado("N/A");
		grupo.setcCarrera("N/A");
		grupo.setcGrupo("N/A");
		
		Grupo[] grupoDefault = {grupo};
		
		return grupoDefault;
	}
	
}