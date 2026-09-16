package co.edu.poli.actividad1Daos;

import java.sql.*;
import java.util.List;

import co.edu.poli.actividad1.model.Producto;

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
		String sql = "INSERT INTO \"producto\"  (\"id_producto\", \"descripcion\", \"disponible\", \"precio\", \"categoria\") VALUES (?, ?, ?, ?, ?)";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setLong(1, p.getIdProducto());
			pstmt.setString(2, p.getDescripcion());
			pstmt.setBoolean(3, p.getDisponible());
			pstmt.setDouble(4, p.getPrecio());
			pstmt.setString(5, p.getCategoria());
			
			pstmt.executeUpdate();
			
			return "Insercion exitosa!";
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public Producto select(String id) {
		String sql = "SELECT * FROM \"producto\" WHERE \"id_producto\" = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				Producto p = new Producto(rs.getLong("id_producto"), rs.getString("descripcion"), rs.getBoolean("disponible"), rs.getDouble("precio"), rs.getString("categoria"));
				
				return p;
			}else {
				System.out.println("Usuario no encontrado");
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Producto> selectAll(){
		
	}
	
	public String update(Producto p) {
		
	}
	
	public String delete(String id) {
		
	}
	
	private Producto mapRStuProducto(ResultSet rs) throws SQLException{
		
	}
}
