package co.edu.poli.actividad1Daos;


import java.sql.*;
import java.util.ArrayList;

public class Plantilla {
	

	
private Connection connection;
	
	public TitularDao () {
		
	}
	
	
	
	public Connection getConnection() {
		return connection;
	}



	public void setConnection(Connection connection) {
		this.connection = connection;
	}



	@Override
	public String insert(Titular t){
		String sql = "INSERT INTO \"Titular\" (\"identificacion\", \"fechaNacimiento\", \"nombre\") VALUES (?, ?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){

			pstmt.setString(1, t.getIdentificacion());
			
			pstmt.setString(2, t.getFechaNacimiento());
			
			pstmt.setString(3, t.getNombre());
			
			pstmt.executeUpdate();
			
			return "Insercion exitosa!";
			
		}catch(SQLException e) {
			
			System.out.println("Error de insercion " + e.getMessage());
			e.printStackTrace();
			
		}
		return "";
	}
	
	

	@Override
	public Titular select(String id) {
		
		String sql = "SELECT * FROM \"Titular\" WHERE \"identificacion\" = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			
			 ResultSet rs = pstmt.executeQuery();
			 
	            if (rs.next()) {
	            	
	            	Titular t = new Titular (rs.getString("identificacion"), rs.getString("fechaNacimiento"), rs.getString("nombre"));
	            	
	            	return t;
	            }
		}catch( SQLException e) {
			System.out.println("Error de lectura " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Titular> selectAll(){
		List<Titular> titulares = new ArrayList<>();
        String sql = "SELECT * FROM \"Titulares\"";
        try (Statement stmt = connection.createStatement()){
             ResultSet rs = stmt.executeQuery(sql); {
             while (rs.next()) {
                titulares.add(mapRStuTitular(rs));
             }
        }
        return titulares;
      
	}catch (SQLException e) {
		System.out.println("Error de lectura " + e.getMessage());
    }
    return null;
	}
	@Override
	public String Update(Titular t) {
		String sql = "UPDATE \"Titular\" SET \"fechaNacimiento\" = ?, \"nombre\" = ? WHERE \"identificacion\" = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, t.getFechaNacimiento());
			
			pstmt.setString(2, t.getNombre());
			
			pstmt.setString(3, t.getIdentificacion());
			
			pstmt.executeUpdate();
			
			return "Actualizacion exitosa!";
			
		}catch(SQLException e) {
			
			System.out.println("Error de actualizacion " + e.getMessage());
			e.printStackTrace();
			
		}
		return "Error de actualizacion";
	}

	@Override
	public String Delete(String id) {
		String sql = "DELETE FROM \"Titular\" WHERE \"identificacion\" = ?" ;
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            
            return "eliminacion exitosa";
        }catch(SQLException e) {
			
			System.out.println("Error de eliminacion " + e.getMessage());
			e.printStackTrace();
			
        }
		return "Error de eliminacion ";
		
	}
	
	private Titular mapRStuTitular(ResultSet rs) throws SQLException{
    		Titular p = new Titular (rs.getString("identificacion"),rs.getString("fechaNacimiento"),rs.getString("nombre"));
    	return p;
	}

}
