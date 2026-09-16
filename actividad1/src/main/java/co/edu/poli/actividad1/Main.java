package co.edu.poli.actividad1;

import java.util.List;

import co.edu.poli.actividad1.model.DetalleProducto;
import co.edu.poli.actividad1.model.Empleado;
import co.edu.poli.actividad1.model.Producto;
import co.edu.poli.actividad1Daos.DetalleProductoDAO;
import co.edu.poli.actividad1Daos.EmpleadoDAO;
import co.edu.poli.actividad1Daos.ProductoDAO;

/**
 *
 * @author Your name
 */
public class Main {
    public static void main(String [] param) {
    	
    	//pruebas empleado
        
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
        
        //pruebas detalle productos
        
        DetalleProductoDAO detalleProductoDAO = new DetalleProductoDAO();
    	
    	detalleProductoDAO.setConnection(DatabaseConnection.getInstance().getconConnection());
    	
        DetalleProducto dp1 = new DetalleProducto((long)1, "sin sal", (long)1, (long)1);
        DetalleProducto dp2 = new DetalleProducto((long)2, "sin picante", (long)1, (long)2);
        DetalleProducto dp3 = new DetalleProducto((long)3, "termino medio", (long)1, (long)3);
        DetalleProducto dp4 = new DetalleProducto((long)1, "sin sal y con papas a la francesa", (long)1, (long)1);
        
        detalleProductoDAO.insert(dp1);
        detalleProductoDAO.insert(dp2);
        detalleProductoDAO.insert(dp3);
        
        List <DetalleProducto> detallesProductos = detalleProductoDAO.selctAll();
        
        System.out.println(detallesProductos.toString());
        
        detalleProductoDAO.Update(dp4);
        
        System.out.println(detalleProductoDAO.select((long)1).toString());
        
        detalleProductoDAO.Delete((long)1);
        detalleProductoDAO.Delete((long)2);
        detalleProductoDAO.Delete((long)3);
        
        // prueba de productos.
        
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.setConnection(DatabaseConnection.getInstance().getconConnection());
        
        Producto p1 = new Producto((long)1, "Panzerotti", null, null, null);
        
        
        
        
        
        
    }
}