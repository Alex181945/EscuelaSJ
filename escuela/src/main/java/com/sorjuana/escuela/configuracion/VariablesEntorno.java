package com.sorjuana.escuela.configuracion;

public class VariablesEntorno {
	
	private static final String URLWSD = "https://localhost:3000/";
	private static final String URLWSP = "https://restmysqlsj.herokuapp.com/";
	private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";
	
	public static String getUrlwsd() {
		return URLWSD;
	}
	public static String getUrlwsp() {
		return URLWSP;
	}
	public static String getTokenPrefix() {
		return TOKEN_PREFIX;
	}
	public static String getHeaderString() {
		return HEADER_STRING;
	}

}
