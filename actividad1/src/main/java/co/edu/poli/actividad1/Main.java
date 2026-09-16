package co.edu.poli.actividad1;

import java.util.List;

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
    	
    	Empleado Allie2 = new Empleado((long)1, "Allie", "Velandia", "allie.velandia@gmail.com", (long) 1);
        
    	Empleado Salo = new Empleado((long)2, "Salo", "Dorado", "salodorado2004@gmail.com", (long) 1);
    	
    	Empleado Sam = new Empleado((long)3, "Sam", "Arce", "wearesysz@outlook.com", (long) 1);
    	
    	empleadoDAO.insert(Salo);
    	empleadoDAO.insert(Sam);
    	empleadoDAO.insert(Allie);
        
        List <Empleado> empleados = empleadoDAO.selectAll();
        
        System.out.println(empleados.toString());
        
        empleadoDAO.Update(Allie2);
        
        System.out.println(empleadoDAO.select((long)1).toString());
        
        empleadoDAO.Delete((long)1);
        empleadoDAO.Delete((long)2);
        empleadoDAO.Delete((long)3);
        
        
        
        
        
    }
}