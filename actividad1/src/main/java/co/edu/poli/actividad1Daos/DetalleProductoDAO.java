package co.edu.poli.actividad1Daos;

import co.edu.poli.actividad1.model.DetalleProducto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
	
	public String insert (DetalleProducto t) {
		String sql = "INSERT INTO\"detalle_producto\"(\"id_detalle_producto\",\"notas\",\"detalle_pedido\",\"producto_id\")VALUES(?,?,?,?)";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			
			pstmt.setLong (1, t.getIdDetalleProducto());
			pstmt.setString (2, t.getNotas());
			pstmt.setLong (3, t.getDetallePedido());
			pstmt.setLong (4, t.getProductoId());
			pstmt.executeUpdate();
			
			return "Insercion exitosa!";
			
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public DetalleProducto select (Long id) {
		
		String sql = "SELECT * FROM \"detalle_producto\" WHERE \"id_detalle_producto\" = ?";
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			
			pstmt.setLong(1, id);
			 ResultSet rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 DetalleProducto dp = mapRStoDetalleProducto(rs);
				 return dp;
			 }else {
				 System.out.println("detalle de producto no encontrado");
				 return null;
			 }
			
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<DetalleProducto> selctAll(){
		
		List<DetalleProducto> detallesProductos = new ArrayList <>();
		 String sql = "SELECT * FROM \"detalle_producto\"";
		 try (Statement stmt = connection.createStatement()){
             ResultSet rs = stmt.executeQuery(sql); {
             while (rs.next()) {
                detallesProductos.add(mapRStoDetalleProducto(rs));
             }
             return detallesProductos;
        }
       
      
	}catch(SQLException e){
		e.printStackTrace();
		return null;
		}
		
		 
	}
	
	public String Update (DetalleProducto e) {
		String sql = "UPDATE \"detalle_producto\" SET \"notas\" = ?, \"detalle_pedido\" = ?,\"producto_id\" = ? WHERE \"id_detalle_producto\" = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, e.getNotas());
			pstmt.setLong(2, e.getDetallePedido());
			pstmt.setLong(3, e.getProductoId());
			pstmt.setLong(4, e.getIdDetalleProducto());
			
			pstmt.executeUpdate();
			
			return "Actualizacion exitosa!";
		}catch(SQLException e1){
			e1.printStackTrace();
			return null;
		}
	}
	
	
	public String Delete (Long id) {
		String sql = "DELETE FROM \"detalle_producto\" WHERE \"id_detalle_producto\" = ?" ;
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, id);;
            pstmt.executeUpdate();
            return "eliminacion exitosa";
            
		}catch(SQLException e){
			e.printStackTrace();
			return null;
			
		}
	}
	public DetalleProducto mapRStoDetalleProducto(ResultSet rs) {
		try {
			DetalleProducto p = new DetalleProducto (rs.getLong("id_detalle_producto"),rs.getString("notas"),rs.getLong("detalle_pedido"),rs.getLong("producto_id"));
			return p;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
			
		}
	}
}
