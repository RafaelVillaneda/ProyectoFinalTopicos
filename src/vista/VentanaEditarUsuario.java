package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class VentanaEditarUsuario extends JInternalFrame implements ActionListener{
	
	public VentanaEditarUsuario() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(147, 192, 244));
		setTitle("Editar Usuario");
		
		setIconifiable(true);//Minimizar
		setResizable(true);//Cambiar tamaño
		setClosable(true);//Cerrar
		
		//String id=JOptionPane.showInputDialog(null, "Introduce el ID. del usuario");
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
