package vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaInicio extends JFrame{
	
	JMenuBar menuBar1,menuBar2;
	JMenu menuAccionesUsuarios;
	JMenuItem menuAltasUsuarios,menuBajasUsuarios,menuEdicionUsuarios;
	
	JMenuItem munuCargaBajaLibros,menuMostrarMovimientos;
	
	public VentanaInicio() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Libreria los Literatos");
		setVisible(true);
		setSize(1200, 725);
		this.getContentPane().setBackground(new Color(147, 192, 244));
		setResizable(false);
		
		menuBar1=new JMenuBar();
			menuAccionesUsuarios=new JMenu("Acciones Usuarios");
				menuAltasUsuarios=new JMenuItem("Agregar nuevo usuario");
				menuBajasUsuarios=new JMenuItem("Bajas Usuarios");
				menuEdicionUsuarios=new JMenuItem("Editar un usuario");
			menuAccionesUsuarios.add(menuAltasUsuarios);
			menuAccionesUsuarios.add(menuBajasUsuarios);
			menuAccionesUsuarios.add(menuEdicionUsuarios);
		menuBar1.add(menuAccionesUsuarios);
		setJMenuBar(menuBar1);
			
		
		
		setLocationRelativeTo(null);
	}
}
