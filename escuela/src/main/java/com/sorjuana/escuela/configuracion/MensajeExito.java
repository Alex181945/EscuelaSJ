package com.sorjuana.escuela.configuracion;

public class MensajeExito {

	private final static String EXITO_CT_MATERIA_INSERTA = "Materia creada exitosamente";
	private final static String EXITO_CT_MATERIA_EDITA   = "Materia actualizada exitosamente";

	public static String getExitoCtMateriaInserta() {
		return EXITO_CT_MATERIA_INSERTA;
	}

	public static String getExitoCtMateriaEdita() {
		return EXITO_CT_MATERIA_EDITA;
	}
	
}