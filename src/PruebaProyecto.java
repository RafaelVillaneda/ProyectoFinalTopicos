import javax.swing.SwingUtilities;

import ConexionBD.*;
import controlador.LibroDAO;
import modelo.Libro;
import vista.VentanaCargaDescargaLibros;
import vista.VentanaInicio;
import vista.VentanaLogin;


public class PruebaProyecto {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			 
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//ConexionBD prueba=new ConexionBD();
				Libro l=new Libro("Prueba", "Horror","Rafael", "La palma");
				LibroDAO lDAO=new LibroDAO();
				lDAO.insertarRegistro(l);
				new VentanaInicio();
				//new VentanaLogin();
			}
		});

	}

}
