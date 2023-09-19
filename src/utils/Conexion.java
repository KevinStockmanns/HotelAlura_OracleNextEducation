package utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;


public class Conexion {
public DataSource dataSource;


public Conexion() {
	ComboPooledDataSource cP = new ComboPooledDataSource();
	cP.setJdbcUrl("jdbc:mysql://localhost/alura_hotel");
	cP.setUser("root");
	cP.setPassword("root");
	
	this.dataSource = cP;
}
public Connection getConexion() {
	try {
		return this.dataSource.getConnection();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
}
