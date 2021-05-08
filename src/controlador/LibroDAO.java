package controlador;

import java.sql.Connection;

import ConexionBD.ConexionBD;
import modelo.Libro;

public class LibroDAO {
	
	public boolean insertarRegistro(Libro a) {
		boolean resultado=false;
	
		resultado=ConexionBD.AgregarRegistroTablaLibros(a);
		
		return resultado;	
	}
	public boolean eliminarRegistro(String sql) {
		
		// DELETE FROM alumnos WHERE NumControl = '01';
		
        boolean resultado = false;
		resultado = ConexionBD.EliminarRegistro(sql);
		
		return resultado;
	}//Modificar
	public boolean modificarLibro(Libro a) {
		boolean resultado = false;
		String sql = "UPDATE libros SET nombre='"+a.getNombre()+"', genero='"+a.getGenero()+"', autor='"+a.getAutor()+"',"
				+ "              editorial = '"+a.getEditorial()+"';";
		
		sql="UPDATE libros SET nombre=? where id_libro="+a.getIDLibro()+"";
		ConexionBD.ActualizarRegistro(a);
		
		return false;
	}
	
	
}
