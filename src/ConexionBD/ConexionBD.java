package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	
	private Connection conexion;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public ConexionBD() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String URL="jdbc:mysql://localhost:3306/libreria";
			
			conexion=DriverManager.getConnection(URL,"root","REVT2001");
		
			System.out.println("CONEXION ESTABLECIDA");
			System.out.println("Ya casi soy Ingeniero inmortal");
			
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR DE DRIVER");
		}catch (SQLException e) {
			System.out.println("Error de conexion a mysql o de la base de datos");
		}
	}
	
	public void cerrarConexion() {
		try {
			pstm.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error de cierre concexion");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new ConexionBD();
	}
	
	//-----------------------METODO PARA OPERCIONES DDL DML (ABC)
	public boolean ejecutarInstruccion(String instrucion) {
		try {
		      // Creamos el PreparedStatement si no estaba ya creado.
		      if (null == pstm) {
		         pstm = conexion.prepareStatement(instrucion);
		      }
		      //(null, ?, ?)
		      pstm.setString(1, "Huevo"); // Mana, el primer interrogante, es un entero.
		      pstm.setString(2, "12/20/2012"); // El String nombre es el segundo interrogante
		      pstm.setInt(3, 12); // Y el tercer interrogante, un precio
	          pstm.executeUpdate();
 	          return true;
		   } catch (SQLException e) {
		      e.printStackTrace();
		   }finally {
			   try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   return false;
	}
	
	
	//------------------------METODO PARA OPERACIONES DE CONSULTAS
	
	
}


