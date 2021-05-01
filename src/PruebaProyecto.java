import javax.swing.SwingUtilities;

import ConexionBD.*;
import vista.VentanaCargaDescargaLibros;
import vista.VentanaInicio;
import vista.VentanaLogin;


public class PruebaProyecto {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			 
			//ConexionBD prueba=new ConexionBD();
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				new VentanaInicio();
				//new VentanaLogin();
			}
		});

	}

}
