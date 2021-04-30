import javax.swing.SwingUtilities;

import vista.VentanaCargaDescargaLibros;
import vista.VentanaInicio;
import vista.VentanaLogin;


public class PruebaProyecto {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			 
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				new VentanaInicio();
				//new VentanaLogin();
			}
		});

	}

}
