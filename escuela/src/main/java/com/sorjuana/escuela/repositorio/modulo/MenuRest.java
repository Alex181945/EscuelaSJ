package com.sorjuana.escuela.repositorio.modulo;

import com.sorjuana.escuela.modelo.datos.consulta.DosParametrosEnteros;
import com.sorjuana.escuela.modelo.modulo.Menu;

/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 07/04/2018
 * Descripcion: Interfaz encargada de traer la informacion
 * del menu en funcion al perfil del usuario
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 *
 * Nota: 0 es falso, 1 es verdadero
 * 
 */

public interface MenuRest {

	public Menu[] cargaMenu(DosParametrosEnteros consulta, String cToken);
	public boolean islResultado();
	public String getMensaje();
	
}
