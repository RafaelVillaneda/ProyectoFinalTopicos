package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaAgregarUsuarios extends JInternalFrame implements ActionListener{
		
		public VentanaAgregarUsuarios() {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			setSize(300,300);
			setTitle("Altas Usuarios");
			setVisible(true);
			
			setIconifiable(true);//Minimizar
			setResizable(true);//Cambiar tamaño
			setClosable(true);//Cerrar
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

