package com.sorjuana.escuela.modelo.modulo;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 07/04/2018
 * Descripcion: Clase para la carga del menu
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

public class Menu {

	private Integer iIDModulo;
	private String  cModulo;
	private Integer iPartida;
	private String  cPrograma;
	private String  cRuta;
	private String  cCExtra;
	private Integer lActivo;

	public Integer getiIDModulo() {
		return iIDModulo;
	}

	public void setiIDModulo(Integer iIDModulo) {
		this.iIDModulo = iIDModulo;
	}

	public String getcModulo() {
		return cModulo;
	}

	public void setcModulo(String cModulo) {
		this.cModulo = cModulo;
	}

	public Integer getiPartida() {
		return iPartida;
	}

	public void setiPartida(Integer iPartida) {
		this.iPartida = iPartida;
	}

	public String getcPrograma() {
		return cPrograma;
	}

	public void setcPrograma(String cPrograma) {
		this.cPrograma = cPrograma;
	}

	public String getcRuta() {
		return cRuta;
	}

	public void setcRuta(String cRuta) {
		this.cRuta = cRuta;
	}

	public String getcCExtra() {
		return cCExtra;
	}

	public void setcCExtra(String cCExtra) {
		this.cCExtra = cCExtra;
	}

	public Integer getlActivo() {
		return lActivo;
	}

	public void setlActivo(Integer lActivo) {
		this.lActivo = lActivo;
	}
	
	@Override
	public String toString() {
		return "Menu [iIDModulo=" + iIDModulo + ", cModulo=" + cModulo + ", iPartida=" + iPartida + ", cPrograma="
				+ cPrograma + ", cRuta=" + cRuta + ", cCExtra=" + cCExtra + ", lActivo=" + lActivo + "]";
	}
	
	public String toJson() {
		return "{"
				+ "iIDModulo:" + iIDModulo + ","
				+ "cModulo:"   + cModulo   + ","
				+ "iPartida:"  + iPartida  + ","
				+ "cRuta:"     + cRuta     + ","
				+ "cCExtra:"   + cCExtra   + ","
				+ "lActivo:"   + lActivo     
				+ "}";
	}
	
	public static Menu[] menuDefault() {
		Menu opcion1 = new Menu();
		Menu opcion2 = new Menu();
		
		opcion1.setiIDModulo(0);
		opcion1.setcModulo("Menu");
		opcion1.setcPrograma("Inicio");
		opcion1.setcRuta("/menu/inicio");
		opcion1.setiPartida(1);
		opcion1.setlActivo(1);
		
		opcion2.setiIDModulo(0);
		opcion2.setcModulo("Menu");
		opcion2.setcPrograma("Cerrar Sesión");
		opcion2.setcRuta("/logout");
		opcion2.setiPartida(2);
		opcion2.setlActivo(1);	
		
		Menu[] menuDefault = {opcion1 , opcion2};
		
		return menuDefault;
	}
	
}