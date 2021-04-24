package vista;

import javax.swing.SwingUtilities;


public class VentanaInicio {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			 
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				//new VentanaInicio();
				new VentanaLogin();
				//new VentanaPrincipal();
				
			}
		});
		
	}

}
