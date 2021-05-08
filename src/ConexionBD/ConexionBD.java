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
	
	public static boolean ActualizarRegistro(){
		 try {
			    String consulta = "update canciones set precio=? where banda='a'";
			    pstm = conexion.prepareStatement(consulta);
		        pstm.setInt(1, 40);
		        pstm.executeUpdate();
		        
		        return true;
		        
		 } catch (Exception ex) {
		        System.out.println(ex.toString());
		 }
		 return false;
	}
	
	public static boolean EliminarRegistro(String filtro){
		 try {
			    String consulta = "delete from canciones where banda=?";
			    pstm = conexion.prepareStatement(consulta);
		        pstm.setString(1, "Mana");
		        pstm.executeUpdate();
		        
		        return true;
		        
		 } catch (Exception ex) {
		        System.out.println(ex.toString());
		 }
		 return false;
	}
	
	public static  ResultSet ConsultarRegistro(){
		
		 try {
			    String consulta = "select * from canciones where banda=?";
			    pstm = conexion.prepareStatement(consulta);
		        pstm.setString(1, "Mana");
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