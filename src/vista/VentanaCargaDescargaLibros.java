package vista;

import java.awt.Color;

import javax.swing.JInternalFrame;

public class VentanaCargaDescargaLibros extends JInternalFrame{
	
	public VentanaCargaDescargaLibros() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(147, 192, 244));
		setTitle("Editar Usuario");
		
		setIconifiable(true);//Minimizar
		setResizable(true);//Cambiar tamaño
		setClosable(true);//Cerrar
		
	}
}
