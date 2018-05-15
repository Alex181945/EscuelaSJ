package com.sorjuana.escuela.configuracion;

public class MensajeExito {

	private final static String EXITO_CT_EDIFICIO_INSERTA = "Edificio creado exitosamente";
	private final static String EXITO_CT_EDIFICIO_EDITA   = "Edificio actualizado exitosamente";

	public static String getExitoCtEdificioInserta() {
		return EXITO_CT_EDIFICIO_INSERTA;
	}

	public static String getExitoCtEdificioEdita() {
		return EXITO_CT_EDIFICIO_EDITA;
	}
	
}