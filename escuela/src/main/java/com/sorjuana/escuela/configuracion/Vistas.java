package com.sorjuana.escuela.configuracion;

public class Vistas {

	/*************************************************************************/
	/***                          Rutas de la plantilla                    ***/
	/*************************************************************************/
	private static final String DEFAULT_LAYOUT = "plantilla/base";
	private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";
	/********************************* Fin ***********************************/
	
	/*************************************************************************/
	/***                          Vistas del sistema                       ***/
	/*************************************************************************/
	private static final String LOGIN = "index";
	private static final String TICKET = "ticket/incidencia";
	private static final String MENU = "menu/menu";
	private static final String CONTROLALUMNO = "controlalum";
	/********************************* Fin ***********************************/
	
	/*************************************************************************/
	/***                         Redireccionamientos                       ***/
	/*************************************************************************/
	private static final String REDIRECT_LOGIN = "redirect:/login";
	private static final String REDIRECT_MENUPRINCIPAL = "redirect:/menu/inicio";
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
	
}
