package co.edu.poli.actividad1Daos;

import java.sql.*;

public class DetalleProductoDAO {
	
	private Connection connection;
	
	public DetalleProductoDAO () {
		
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	

}
