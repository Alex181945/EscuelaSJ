package com.sorjuana.escuela.configuracion;

public class Vistas {

	/*************************************************************************/
	/*** Rutas de la plantilla ***/
	/*************************************************************************/
	private static final String DEFAULT_LAYOUT = "plantilla/base";
	private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";
	/********************************* Fin ***********************************/

	/*************************************************************************/
	/*** Vistas del sistema ***/
	/*************************************************************************/
	private static final String LOGIN = "index";
	private static final String TICKET = "ticket/incidencia";
	private static final String MENU = "menu/menu";
	private static final String CONTROLALUMNO = "consultaalumno";
	private static final String FORMULARIOALUMNO = "controlalum";
	private static final String FORMULARIOMATERIA = "controlmateria";
	private static final String CONSULTAOMATERIA = "consultamat";
	private static final String CONTROLCALIFICACIONES = "controlcalif";
	private static final String CONTROLGRUPO = "controlgrupo";
	private static final String CONTROLASISTENCIA = "consultaasis";
	private static final String FORMULARIOASISTENCIA = "controlasis";
	private static final String FORMULARIOADMIN = "controladmin";
	private static final String CONTROLADMIN = "consultadmin";
	private static final String CONTROLDOCENTE = "consultadoc";
	private static final String FORMULARIODOCENTE = "controld";
	private static final String FORMULARIOKARDEX = "Kardex/kardex";
	private static final String HISTORIALKARDEX = "Kardex/genera_kardex";
	private static final String CARGAKARDEX = "Kardex/carga_kardex";
	private static final String CONSULTAGRUPO = "consultagrupo";
	/********************************* Fin ***********************************/

	/*************************************************************************/
	/*** Redireccionamientos ***/
	/*************************************************************************/
	private static final String REDIRECT_LOGIN = "redirect:/login";
	private static final String REDIRECT_MENUPRINCIPAL = "redirect:/menu";
	private static final String REDIRECT_MODULO = "redirect:/carga/modulo";
	private static final String REDIRECT_TICKET = "redirect:/ticket";

	/********************************* Fin ***********************************/

	public static String getDefaultLayout() {
		return DEFAULT_LAYOUT;
	}

	public static String getDefaultViewAttributeName() {
		return DEFAULT_VIEW_ATTRIBUTE_NAME;
	}

	public static String getRedirectLogin() {
		return REDIRECT_LOGIN;
	}

	public static String getRedirectMenuprincipal() {
		return REDIRECT_MENUPRINCIPAL;
	}

	public static String getRedirectModulo() {
		return REDIRECT_MODULO;
	}

	public static String getRedirectTicket() {
		return REDIRECT_TICKET;
	}

	public static String getLogin() {
		return LOGIN;
	}

	public static String getTicket() {
		return TICKET;
	}

	public static String getMenu() {
		return MENU;
	}

	public static String getControlalumno() {
		return CONTROLALUMNO;
	}

	public static String getControlasistencia() {
		return CONTROLASISTENCIA;
	}

	public static String getControladmin() {
		return CONTROLADMIN;
	}

	public static String getControldocente() {
		return CONTROLDOCENTE;
	}

	public static String getFormulariodocente() {
		return FORMULARIODOCENTE;
	}

	public static String getFormularioalumno() {
		return FORMULARIOALUMNO;
	}

	public static String getFormularioadmin() {
		return FORMULARIOADMIN;
	}

	public static String getFormularioasistencia() {
		return FORMULARIOASISTENCIA;
	}

	public static String getFormulariokardex() {
		return FORMULARIOKARDEX;
	}

	public static String getHistorialkardex() {
		return HISTORIALKARDEX;
	}

	public static String getCargakardex() {
		return CARGAKARDEX;
	}

	public static String getControlcalificaciones() {
		return CONTROLCALIFICACIONES;
	}

	public static String getControlgrupo() {
		return CONTROLGRUPO;
	}

	public static String getFormulariomateria() {
		return FORMULARIOMATERIA;
	}

	public static String getConsultaomateria() {
		return CONSULTAOMATERIA;
	}

	public static String getConsultagrupo() {
		return CONSULTAGRUPO;
	}
}
