package co.edu.poli.actividad1Daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.actividad1.model.Producto;

public class ProductoDAO {
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public ProductoDAO() {
		super();
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public String insert(Producto p) {
		String sql = "INSERT INTO \"producto\"  (\"id_producto\", \"nombre\", \"descripcion\", \"disponible\", \"precio\", \"categoria\") VALUES (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setLong(1, p.getIdProducto());
			pstmt.setString(2, p.getNombre());
			pstmt.setString(3, p.getDescripcion());
			pstmt.setBoolean(4, p.getDisponible());
			pstmt.setDouble(5, p.getPrecio());
			pstmt.setString(6, p.getCategoria());
			
			pstmt.executeUpdate();
			
			return "Insercion exitosa!";
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public Producto select(Long id) {
		String sql = "SELECT * FROM \"producto\" WHERE \"id_producto\" = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				Producto p = new Producto(rs.getLong("id_producto"), rs.getString("nombre"), rs.getString("descripcion"), rs.getBoolean("disponible"), rs.getDouble("precio"), rs.getString("categoria"));
				
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
		List<Producto> productos = new ArrayList<Producto>();
		String sql = "SELECT * FROM \"producto\"";
		try(Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				productos.add(mapRStuProducto(rs));
			}
			return productos;
		} catch (SQLException e) {
			e.printStackTrace();
			return productos;
		}
	}
	
	public String update(Producto p) {
		String sql = "UPDATE \"producto\" SET \"nombre\" = ?, \"descripcion\" = ?, \"disponible\" = ?, \"precio\" = ?, \"categoria\" = ? WHERE \"id_producto\" = ?";
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, p.getNombre());
			pstmt.setString(2, p.getDescripcion());
			pstmt.setBoolean(3, p.getDisponible());
			pstmt.setDouble(4, p.getPrecio());
			pstmt.setString(5, p.getCategoria());
			pstmt.setLong(6, p.getIdProducto());
			
			pstmt.executeUpdate();
			
			return "Actualizacion exitosa!";
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String delete(Long id) {
		String sql = "DELETE FROM \"producto\" WHERE \"id_producto\" = ?";
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setLong(1, id);
			
			pstmt.executeUpdate();
			
			return "Eliminacion exitosa";
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private Producto mapRStuProducto(ResultSet rs) throws SQLException{
		Producto p = new Producto(rs.getLong("id_producto"), rs.getString("nombre"), rs.getString("descripcion"), rs.getBoolean("disponible"), rs.getDouble("precio"), rs.getString("categoria"));
		return p;
	}
}
