package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.Conexion;

public class Usuario {
	private String nombre;
	private String clave;
	
	public Usuario(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public static boolean validarUsuario(String nombre, String clave) {
		Conexion conexion = new Conexion();
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			connection = conexion.getConexion();
			state = connection.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND contraseña = ?");
			state.setString(1, nombre);
			state.setString(2, clave);
			result = state.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if (result !=null)
					result.close();
				if (state !=null)
					state.close();
				if (connection !=null)
					connection.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
		
		
		
	}

}
