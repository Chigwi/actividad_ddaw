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
		
		String sql = "INSERT INTO \"empleado\" (\"id_empleado\", \" nombre\", \" apellido\", \"correo\", \" rol\" ) VALUES (?,?,?,?,?)";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			
			pstmt.setLong(1, e.getIdEmpleado());
			
			pstmt.setString(2, e.getNombre());
			
			pstmt.setString(3, e.getApellido());
			
			pstmt.setString(4, e.getCorreo());
			
			pstmt.setLong(5, e.getRol());
			
			pstmt.executeUpdate();
			
			return "Inserción exitosa!";
			
		}catch(SQLException ex) {
			
			ex.printStackTrace();
			
			return null;
			
		}
		
	}
	
	public Empleado select (Long id) {
		
		String sql = "SELECT * FROM \"empleado\" WHERE \"id_empleado\" = ?";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			
			pstmt.setLong(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				Empleado em = mapRStoEmpleado(rs);
				
				return em;
			}else {
				
				System.out.println("Empleado no encontrado");
				
				return null;
				
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
			return null;
		}
		
	}
	
	public List <Empleado> selectAll(){
		
	}
	
	public String Update (Empleado e) {
		
	}
	
	public String Delete (Long id) {
		
	}
	
	public Empleado mapRStoEmpleado(ResultSet rs) {
		try {
			
			Empleado p = new Empleado(rs.getLong("id_empleado"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"),rs.getLong("rol") );
			
			return p;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
			return null;
		}
		
		
		
	}
	
	
	
	

}
