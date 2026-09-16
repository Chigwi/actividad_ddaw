package co.edu.poli.actividad1Daos;

import java.sql.Connection;


import java.sql.*;

public class EmpleadoDAO {
	
	private Connection connection;

	public EmpleadoDAO() {

	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
	

}
