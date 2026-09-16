package co.edu.poli.actividad1Daos;

import java.sql.*;

public class ProductoDAO {
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public ProductoDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public String insert(Producto p) {
		
	}
}
