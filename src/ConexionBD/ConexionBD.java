package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Libro;

public class ConexionBD {

	private static Connection conexion=null;
	private static PreparedStatement pstm; //NO es tan seguro ya que permite SQL Injection, se recomienda PreparedStatement
	private static ResultSet rs;
	
	private ConexionBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String URL = "jdbc:mysql://localhost:3306/libreria";
			
			conexion = DriverManager.getConnection(URL, "root", "REVT2001");
			
			System.out.println("Conexion establecida!!!!");
			System.out.println("Ya casi soy Ingeniero inmortal");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error de DRIVER");
		} catch (SQLException e) {
			System.out.println("Error de conexion en MySQL");
		}
	}
	public static Connection getConexion(){
		  
		 if (conexion == null){
		     new ConexionBD();
		 }
		  
		 return conexion;
   }

	
	static void cerrarConexion() {
		try {
			pstm.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion");
			e.printStackTrace();
		}
	}
	
	// --------------------- Metodo para operaciones DDL y DML (ABC - Altas, Bajas y Cambios)
	
	public static boolean ActualizarRegistro(Libro a){
		
		 try {
			    pstm = conexion.prepareStatement("UPDATE libros SET nombre=?,genero=?,autor=?,editorial=? where id_libro="+a.getIDLibro()+"");
			    pstm.setString(1,a.getNombre());
			    pstm.setString(2,a.getGenero());
			    pstm.setString(3,a.getAutor());
			    pstm.setString(4,a.getEditorial());
			    
		        pstm.executeUpdate();
		        
		        return true;
		        
		 } catch (Exception ex) {
		        System.out.println(ex.toString());
		 }
		 return false;
	}
	
	public static boolean EliminarRegistro(String instruccion){
		 try {
			    String consulta = instruccion;
			    pstm = conexion.prepareStatement(consulta);
		        pstm.executeUpdate();
		        
		        return true;
		        
		 } catch (Exception ex) {
		        System.out.println(ex.toString());
		 }
		 return false;
	}
	
	public static  ResultSet ConsultarRegistro(String consulta){
		
		 try {
			    pstm = conexion.prepareStatement(consulta);
		        return pstm.executeQuery();
		        
		 } catch (Exception ex) {
		        System.out.println(ex.toString());
		 }
		 return null;
	}

	public static   boolean AgregarRegistroTablaLibros(Libro libiro) {
		try {
		      // Creamos el PreparedStatement si no estaba ya creado.
		         pstm = conexion.prepareStatement("insert into libros values(null,?,?,?,?)");
		      
		      pstm.setString(1,libiro.getNombre());
		      pstm.setString(2,libiro.getGenero());
		      pstm.setString(3,libiro.getAutor());
		      pstm.setString(4,libiro.getEditorial());
		      
	          pstm.executeUpdate();
 	          return true;
		         
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return false;
	}
	
}