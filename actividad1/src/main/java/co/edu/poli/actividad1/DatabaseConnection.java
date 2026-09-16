package co.edu.poli.actividad1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection {
	
	private static DatabaseConnection instance;
	
	private Connection connection;
	
	private DatabaseConnection () {
		
		try {
			
			String url = "jdbc:postgresql://192.168.0.4:5432/nombre";
					
			String user = "user";
			
			String password = "Servidor123";
			
			connection = DriverManager.getConnection(url,user,password);
	
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static DatabaseConnection getInstance() {
		if(instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}
	public Connection getconConnection() {
		return connection;
	}
	
	
	

}
