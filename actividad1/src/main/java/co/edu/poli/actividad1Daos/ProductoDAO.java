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
		String sql = "SELECT * FROM \"producto\" WHERE \"id_producto\" = ?";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, p.getDescripcion());
			pstmt.setBoolean(2, p.getDisponible());
			pstmt.setDouble(3, p.getPrecio());
			pstmt.setString(4, p.getCategoria());
			
			
		}
	}
	
	public Producto select(String id) {
		
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
