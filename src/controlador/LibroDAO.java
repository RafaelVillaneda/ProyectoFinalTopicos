package controlador;

import ConexionBD.ConexionBD;
import modelo.Libro;

public class LibroDAO {
	ConexionBD conexion;
	public LibroDAO() {
		conexion=new ConexionBD();
	}
	
	public boolean insertarRegistro(Libro a) {
		boolean resultado=false;
		String sql="insert into libros values(null,?,?,?,?)";
		
		resultado=conexion.AgregarRegistroTablaLibros(a);
		
		return resultado;	
	}
	
}
