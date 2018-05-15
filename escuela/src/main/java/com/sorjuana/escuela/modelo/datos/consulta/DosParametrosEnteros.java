package com.sorjuana.escuela.modelo.datos.consulta;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 07/04/2018
 * Descripcion: Clase para realizar consulta a servicios
 * para dos parametros enteros
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

public class DosParametrosEnteros {

	private Integer parametro1;
	private Integer parametro2;
		
	public Integer getParametro1() {
		return parametro1;
	}
	public void setParametro1(Integer parametro1) {
		this.parametro1 = parametro1;
	}
	public Integer getParametro2() {
		return parametro2;
	}
	public void setParametro2(Integer parametro2) {
		this.parametro2 = parametro2;
	}
	
	@Override
	public String toString() {
		return "DosParametrosEnteros [parametro1=" + parametro1 + ", parametro2=" + parametro2 + "]";
	}
	
	public String toJson() {
		return "{"
				+ "parametro1:" + parametro1 + ","
				+ "parametro2:" + parametro2     
				+ "}";
	}
	
}
