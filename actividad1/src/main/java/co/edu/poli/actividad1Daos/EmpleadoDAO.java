package co.edu.poli.actividad1Daos;

import java.sql.*;
import co.edu.poli.actividad1.model.Empleado;

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
	
	public String insert (Empleado e) {
		
	}
	
	public Empleado select (Long id) {
		
	}
	
	public List <Empleado> selectAll(){
		
	}
	
	public String Update (Empleado e) {
		
	}
	
	public String Delete (Long id) {
		
	}
	
	public Empleado mapRStoEmpleado(ResultSet rs) {
		
	}
	
	
	
	

}
