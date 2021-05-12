import javax.swing.SwingUtilities;


import java.sql.Connection;
import ConexionBD.*;
import controlador.LibroDAO;
import modelo.Libro;
import modelo.Usuario;
import vista.VentanaCargaDescargaLibros;
import vista.VentanaInicio;
import vista.VentanaLogin;


public class PruebaProyecto {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			 
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Connection a = ConexionBD.getConexion();
				
				//LibroDAO lDAO=new LibroDAO();
				
				//lDAO.modificarLibro(new Libro("hola", "Horror","Ricardo", "La palma",1));
				//new VentanaInicio();
				
				Usuario u=new Usuario(0, "Rafel Eulalio", "Villaneda","de la torre","rafaeua2401@outlook.com");
				//ConexionBD.AgregarRegistroTablaUsuarios(u);
				
				new VentanaLogin();
				
			}
		});

	}

}
