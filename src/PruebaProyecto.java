import javax.swing.SwingUtilities;


import java.sql.Connection;
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
				Connection a = ConexionBD.getConexion();
				Libro l=new Libro("prueba2", "Horror","Ricardo", "La palma");
				LibroDAO lDAO=new LibroDAO();
				lDAO.insertarRegistro(l);
				new VentanaInicio();
				//new VentanaLogin();
			}
		});

	}

}
