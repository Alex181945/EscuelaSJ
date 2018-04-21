package com.sorjuana.escuela.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static final String cURLDevelop = "jdbc:mysql://localhost:3306/escuelast";
	//private static final String cURLProduction = "jdbc:mysql://localhost:3306/escuela";
	
	public static Connection GetConnection(){
		
		Connection conexion = null;
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(cURLDevelop,"root", "");
            System.out.println("Me conecte exitosamente");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de Conexión Intente Mas Tarde"
                    + " O Contacté con el área de Sistemas"+"\n"+e);
        }
		return conexion;
	}
}
