package co.edu.poli.actividad1Daos;

import co.edu.poli.actividad1.model.DetalleProducto;
import java.sql.*;
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
		return  null;
	}
	
	public DetalleProducto select (Long id) {
		return null;
	}
	
	public List<DetalleProducto> selctAll(){
		return null;
		
	}
	
	public String Update (DetalleProducto e) {
		return null;
	}
	
	public String Delete (Long id) {
		return null;
	}
	public DetalleProducto mapRStoDetalleProducto(ResultSet rs) {
		return null;
	}
}
