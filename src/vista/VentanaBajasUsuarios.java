package vista;

import javax.swing.JInternalFrame;

public class VentanaBajasUsuarios extends JInternalFrame {
	public VentanaBajasUsuarios() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(300,300);
		setTitle("Bajas Usuarios");
		setVisible(true);
		
		setIconifiable(true);//Minimizar
		setResizable(true);//Cambiar tamaño
		setClosable(true);//Cerrar
	}
}
