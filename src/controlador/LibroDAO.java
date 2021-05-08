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
	
	
}
