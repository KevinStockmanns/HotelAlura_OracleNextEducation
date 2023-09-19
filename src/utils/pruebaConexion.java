package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class pruebaConexion {
	
	public static void main(String[] args) throws SQLException {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConexion();
		
		System.out.println("Probando conexion");
		
		con.close();
	}

}
