package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	
	private Connection conexion;
	private Statement stm;
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
			stm.close();
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
	public boolean ejecutarInstruccion(String sql) {
		try {
			stm= conexion.createStatement();
			int resultado=stm.executeUpdate(sql); //1 todobien 2 todo mal
			return resultado==1?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//------------------------METODO PARA OPERACIONES DE CONSULTAS
	public ResultSet ejecutarConsulta(String sql) {
		try {
			stm=conexion.createStatement();
			rs=stm.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("No se pudo crear la");
			e.printStackTrace();
		}
		return rs;
	}
	
}


