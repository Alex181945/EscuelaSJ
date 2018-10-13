package com.sorjuana.escuela.modelo.ct;

public class GrupoDetalle {

	private Integer iGrupo;
	private Integer iPartida;
	private Integer iTipoPersona;
	private Integer iPersona;
	private Integer iMateria;
	private Integer lActivo;
	private String dtCreado;
	private String dtModificado;
	
	private String cGrupo;
	private String cTipoPersona;
	private String cPersona;
	private String cMateria;
	
	public Integer getiGrupo() {
		return iGrupo;
	}
	public void setiGrupo(Integer iGrupo) {
		this.iGrupo = iGrupo;
	}
	public Integer getiPartida() {
		return iPartida;
	}
	public void setiPartida(Integer iPartida) {
		this.iPartida = iPartida;
	}
	public Integer getiTipoPersona() {
		return iTipoPersona;
	}
	public void setiTipoPersona(Integer iTipoPersona) {
		this.iTipoPersona = iTipoPersona;
	}
	public Integer getiPersona() {
		return iPersona;
	}
	public void setiPersona(Integer iPersona) {
		this.iPersona = iPersona;
	}
	public Integer getiMateria() {
		return iMateria;
	}
	public void setiMateria(Integer iMateria) {
		this.iMateria = iMateria;
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
	public String getcGrupo() {
		return cGrupo;
	}
	public void setcGrupo(String cGrupo) {
		this.cGrupo = cGrupo;
	}
	public String getcTipoPersona() {
		return cTipoPersona;
	}
	public void setcTipoPersona(String cTipoPersona) {
		this.cTipoPersona = cTipoPersona;
	}
	public String getcPersona() {
		return cPersona;
	}
	public void setcPersona(String cPersona) {
		this.cPersona = cPersona;
	}
	public String getcMateria() {
		return cMateria;
	}
	public void setcMateria(String cMateria) {
		this.cMateria = cMateria;
	}
	
	public static GrupoDetalle[] grupoDetalleDefault() {
		
		GrupoDetalle grupoDetalle = new GrupoDetalle();
		grupoDetalle.setiGrupo(0);
		grupoDetalle.setiPartida(0);
		grupoDetalle.setiTipoPersona(0);
		grupoDetalle.setiPersona(0);		
		grupoDetalle.setiMateria(0);
		grupoDetalle.setlActivo(0);
		grupoDetalle.setDtCreado("N/A");
		grupoDetalle.setDtModificado("N/A");
		
		grupoDetalle.setcGrupo("N/A");
		grupoDetalle.setcTipoPersona("N/A");
		grupoDetalle.setcMateria("N/A");
		grupoDetalle.setcPersona("N/A");
		
		GrupoDetalle[] grupoDetalleDefault = {grupoDetalle};
		
		return grupoDetalleDefault;
	}
	
}
