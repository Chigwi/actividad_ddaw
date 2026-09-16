package co.edu.poli.actividad1Daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Plantilla {
	
private Connection connection;
	
	public PasaporteDao () {
	}
	
	public Connection getConnection() {
		return connection;
	}
	
//holi
	public void setConnection(Connection connection) {
		this.connection = connection;
	}



	@Override
	public String insert(Pasaporte t){
		String sql = "INSERT INTO \"Pasaporte\" (\"numeroId\", \"paisEmisor\", \"fechaEmision\", \"fechaExpiracion\", titular, \"ciudadEmision\",\"Es\") VALUES (?, ?, ?, ?, ?, ?,?)";
		String sql1 = "INSERT INTO \"POrdinario\"(\"numeroId\",\"razonViaje\")VALUES (?, ?)";
		String sql2 = "INSERT INTO \"PDiplomatico\"(\"numeroId\",\"misionDiplomatica\")VALUES (?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, t.getNumeroId());
			
			pstmt.setString(2, t.getPaisEmisor().getIdPais());
			
			pstmt.setString(3, t.getFechaEmision());
			
			pstmt.setString(4, t.getFechaExpiracion());
			
			pstmt.setString(5, t.getTitular().getIdentificacion());
			
			pstmt.setString(6, t.getCiudadEmision().getCodigoPostal());
			
			if (t.getEs() == null) {
				pstmt.setString(7, "N/A");
			}else {
				pstmt.setString(7, t.getEs().getIdL());
			}
			
			pstmt.executeUpdate();
			
			if(t instanceof POrdinario) {
				POrdinario p = (POrdinario) t;
				try(PreparedStatement pstmt1 = connection.prepareStatement(sql1)){
					pstmt1.setString(1, p.getNumeroId());
					pstmt1.setString(2, p.getRazonViaje());
					pstmt1.executeUpdate();

				}
				
			}
			else if(t instanceof PDiplomatico) {
				PDiplomatico p = (PDiplomatico) t;
				try(PreparedStatement pstmt2 = connection.prepareStatement(sql2)){
					pstmt2.setString(1, p.getNumeroId());
					pstmt2.setString(2, p.getMisionDiplomatica());
					pstmt2.executeUpdate();
				}
			}
			else {
				return "Tipo de pasaporte desconocido";
			}
			return "Insercion exitosa!";
			
		}catch(SQLException e) {
			Alert a = new Alert (AlertType.INFORMATION);
			
	    	a.setContentText("Error de insercion " + e.getMessage());
	    	
	    	a.showAndWait();
			
			System.out.println("Error de insercion " + e.getMessage());
			e.printStackTrace();
			
		}
		return "";
	}
	
	@Override
	public Pasaporte select(String id) {
		
		String sql = "SELECT * FROM \"Pasaporte\" WHERE \"numeroId\" = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			
			
			
			 ResultSet rs = pstmt.executeQuery();
			 
	            if (rs.next()) {
	            	
	            	if(existsInTable("POrdinario", id)) {
	            		
	            		
	            		
	            		return mapRStuPasaporteO(rs);
	            		
	            	}
	            	else if (existsInTable("PDiplomatico", id)) {
	            		
	            		
	            		
	            		return mapRStuPasaporteD(rs);
	            		
	            	}
	            }
		}catch( SQLException e) {
			Alert a = new Alert (AlertType.INFORMATION);
			
	    	a.setContentText("Error de lectura " + e.getMessage());
	    	
	    	a.showAndWait();
			System.out.println("Error de lectura " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Pasaporte> selectAll(){
		
		List<Pasaporte> pasaportes = new ArrayList<>();
		
        String sql = "SELECT * FROM \"Pasaporte\"";
        
        try (Statement stmt = connection.createStatement()){
        	
             ResultSet rs = stmt.executeQuery(sql); {
            	 
             while (rs.next()) {
            	 Pasaporte p = mapRsTuPasaporte(rs);
            	 if(p!=null) {
            		 pasaportes.add(p);
            	 }
             }
        }
        return pasaportes;
      
	}catch (SQLException e) {
		Alert a = new Alert (AlertType.INFORMATION);
		
    	a.setContentText("Error de lectura " + e.getMessage());
    	
    	a.showAndWait();
		
		System.out.println("Error de lectura " + e.getMessage());
    }
    return null;
	}
	@Override
	public String Update(Pasaporte t) {
		String sql = "UPDATE \"Pasaporte\" SET \"paisEmisor\" = ?, \"fechaEmision\" = ?, \"fechaExpiracion\" = ?, \"titular\" = ?, \"ciudadEmision\", \"Es\" = ? WHERE \"numeroId\" = ?";
		
		String sql1 = "UPDATE \"POrdinario\" SET \"razonViaje\" = ? WHERE \"numeroId\" = ? ";
		
		String sql2 = "UPDATE \"PDiplomatico\" SET \"misionDiplomatica\" = ? WHERE \"numeroId\" = ? ";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, t.getPaisEmisor().getIdPais());
			
			pstmt.setString(2, t.getFechaEmision());
			
			pstmt.setString(3, t.getFechaExpiracion());
			
			pstmt.setString(4, t.getTitular().getIdentificacion());
			
			pstmt.setString(5, t.getCiudadEmision().getCodigoPostal());
			
			pstmt.setString(6, t.getEs().getIdL());
			
			pstmt.setString(7, t.getNumeroId());
			
			pstmt.executeUpdate();
			
			if(t instanceof POrdinario) {
				POrdinario p = (POrdinario) t;
				try(PreparedStatement pstmt1 = connection.prepareStatement(sql1)){
					pstmt1.setString(1, p.getRazonViaje() );
					pstmt1.setString(2, p.getNumeroId());
					pstmt1.executeUpdate();
					
				}
				
			}
			else if(t instanceof PDiplomatico) {
				PDiplomatico p = (PDiplomatico) t;
				try(PreparedStatement pstmt2 = connection.prepareStatement(sql2)){
					pstmt2.setString(1, p.getMisionDiplomatica());
					pstmt2.setString(2, p.getNumeroId());
					pstmt2.executeUpdate();
					
				}
			}
			else {
				return "Tipo de pasaporte desconocido";
			}
			
			return "Actualizacion exitosa!";
			
		}catch(SQLException e) {
			Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText("Error de actualizacion " + e.getMessage());
        	
        	a.showAndWait();
			System.out.println("Error de actualizacion " + e.getMessage());
			e.printStackTrace();
			
		}
		return "Error de actualizacion";
	}

	@Override
	public String Delete(String id) {
		
		Pasaporte t = select(id);
		
		String sql = "DELETE FROM \"Pasaporte\" WHERE \"numeroId\" = ?" ;
		
		String sql1 = "DELETE FROM \"POrdinario\" WHERE \"numeroId\" = ? ";
		
		String sql2 = "DELETE FROM \"PDiplomatico\" WHERE \"numeroId\" = ? ";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, id);
            
            
            Pasaporte b = select(id);
            
            if(b instanceof POrdinario) {
				POrdinario p = (POrdinario) t;
				try(PreparedStatement pstmt1 = connection.prepareStatement(sql1)){
					pstmt1.setString(1, p.getNumeroId());
					pstmt1.executeUpdate();
					pstmt.executeUpdate();
				}
				
			}
			else if(b instanceof PDiplomatico) {
				PDiplomatico p = (PDiplomatico) t;
				try(PreparedStatement pstmt2 = connection.prepareStatement(sql2)){
					pstmt2.setString(1, p.getNumeroId());
					pstmt2.executeUpdate();
					pstmt.executeUpdate();
				}
			}
			else {
				return "Tipo de pasaporte desconocido";
			}
            
            return "eliminacion exitosa";
        }catch(SQLException e) {
        	
        	Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText("Error de eliminacion " + e.getMessage());
        	
        	a.showAndWait();
	        
			
			System.out.println("Error de eliminacion " + e.getMessage());
			e.printStackTrace();
			
        }
		return "Error de eliminacion ";
		//comentario
	}
	
	public List<Pasaporte> selectIdFiltered(String condicion) {
	    java.util.List<Pasaporte> pasaportes = new ArrayList()<>();
	    String sql = "SELECT * FROM \"Pasaporte\" WHERE \"numeroId\" LIKE ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, "%" + condicion + "%");
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	        	Pasaporte p = mapRsTuPasaporte(rs);
	        	if(p!=null) {
	        		pasaportes.add(p);
	        	}
	            
	        }
	        return pasaportes;
	    } catch (SQLException e) {
	    	Alert a = new Alert (AlertType.INFORMATION);
    		
        	a.setContentText("Error de lectura " + e.getMessage());
        	
        	a.showAndWait();
	        System.out.println("Error de lectura " + e.getMessage());
	    }
	    return pasaportes;
	}
	//busca si el pasaporte es ordinario o diplomatico
	private boolean existsInTable (String tableName, String id) throws SQLException {
		
		String sql = "SELECT 1 FROM \"" + tableName + "\" WHERE \"numeroId\" = ?";
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			return rs.next();
		}
	}
	//mapea rs a un pasaporte ordinario
	private POrdinario mapRStuPasaporteO(ResultSet rs) throws SQLException{
		
		TitularDao regtit = new TitularDao();
		regtit.setConnection(connection);
		
		CiudadDao regCiu = new CiudadDao();
		regCiu.setConnection(connection);
		
		PaisDao regPais = new PaisDao();
		regPais.setConnection(connection);
		
		Titular selectTitular = regtit.select(rs.getString("Titular"));
		
    	Ciudad selectCiudad = regCiu.select(rs.getString("ciudadEmision"));
    	
    	
    	Pais selectPais = regPais.select(rs.getString("paisEmisor"));
    	
    	ElementoSeguridad es = new ElementoSeguridad(rs.getString("Es"), null, null);
    	
    	List <Ciudad> c = new ArrayList<Ciudad>();
    	
    	c.add(selectCiudad);
    		
    	selectPais.setCiudades(c);
    	
    	String sql = "SELECT * FROM \"POrdinario\" WHERE \"numeroId\" = ?";
    	try (PreparedStatement pstmt = connection.prepareStatement(sql)){
    		pstmt.setString(1, rs.getString("numeroId"));
    		
    		try(ResultSet rs1 = pstmt.executeQuery()){
    			if(rs1.next()) {
    				return null ;// new POrdinario(rs.getString("numeroId"), selectPais, rs.getString("fechaEmision"),
    				//rs.getString("fechaExpiracion"), selectTitular, selectCiudad, rs1.getString("razonViaje"),es);
    			}
    			else {
    				return null;
    			}
    		}
    		
    		
    	}
    	
	}
	//mapea rs a un pasaporte diplomatico
	private PDiplomatico mapRStuPasaporteD(ResultSet rs) throws SQLException{
	
		TitularDao regtit = new TitularDao();
		regtit.setConnection(connection);
		
		CiudadDao regCiu = new CiudadDao();
		regCiu.setConnection(connection);
		
		PaisDao regPais = new PaisDao();
		regPais.setConnection(connection);
		
		Titular selectTitular = regtit.select(rs.getString("Titular"));
		

    	Ciudad selectCiudad = regCiu.select(rs.getString("ciudadEmision"));
    	
    	Pais selectPais = regPais.select(rs.getString("paisEmisor"));
    	
    	ElementoSeguridad es = new ElementoSeguridad(rs.getString("Es"), null, null);

    	List <Ciudad> c = new ArrayList<Ciudad>();
    	
    	c.add(selectCiudad);
    		
    	selectPais.setCiudades(c);
    				
    	String sql = "SELECT * FROM \"PDiplomatico\" WHERE \"numeroId\" = ?";
    
    	try (PreparedStatement pstmt = connection.prepareStatement(sql)){
    	
    		pstmt.setString(1, rs.getString("numeroId"));

    		try(ResultSet rs1 = pstmt.executeQuery()){
    			if(rs1.next()) {
    	    		return new PDiplomatico(rs.getString("numeroId"), selectPais, rs.getString("fechaEmision"), 
    	    		rs.getString("fechaExpiracion"), selectTitular, selectCiudad, rs1.getString("misionDiplomatica"),es);
    			}
    			else {
    				return null;
    			}
    		}
    		
    	}
		
	}
	//junta los metodos de mapeo y retorna el objeto correcto
	private Pasaporte mapRsTuPasaporte(ResultSet rs) throws SQLException{
		
		String numeroId = rs.getString("numeroId");
		
		if(existsInTable("POrdinario", numeroId)) {
			return mapRStuPasaporteO(rs);
		}
		else if(existsInTable("PDiplomatico", numeroId)) {
			return mapRStuPasaporteD(rs);
		}
		else {
			System.out.println("tipo no valido de pasaporte");
			return null;
		}
	}

}
