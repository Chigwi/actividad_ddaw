package co.edu.poli.actividad1;

import co.edu.poli.actividad1.model.Empleado;
import co.edu.poli.actividad1Daos.EmpleadoDAO;

/**
 *
 * @author Your name
 */
public class Main {
    public static void main(String [] param) {
        
    	EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    	
    	empleadoDAO.setConnection(DatabaseConnection.getInstance().getconConnection());
    	
    	Empleado Allie = new Empleado((long)1, "Allie", "Velandia", "allie.velandia@outlook.com", (long) 1);
    	
        empleadoDAO.insert(Allie);
        
        empleadoDAO.selectAll();
        
        
    }
}