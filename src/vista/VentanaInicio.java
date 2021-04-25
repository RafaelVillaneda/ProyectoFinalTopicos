package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class VentanaInicio extends JFrame {
	
	JMenuBar menuBar1;
	JMenu menuAccionesUsuarios,menuAccionesLibros;
	JMenuItem menuAltasUsuarios,menuBajasUsuarios,menuEdicionUsuarios;
	
	JMenuItem munuCargaBajaLibros,menuMostrarMovimientos;
	
	JInternalFrame IF_AltasUsuarios,IF_BajasUsuarios;
	JDesktopPane dp=new JDesktopPane();
	
	public VentanaInicio() {
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Libreria los Literatos");
		setVisible(true);
		setSize(1200, 725);
		this.getContentPane().setBackground(new Color(147, 192, 244));
		setResizable(false);
		
		
		//Menu item Acciones Usuarios
		
		menuBar1=new JMenuBar();
			menuAccionesUsuarios=new JMenu("Acciones Usuarios");
				menuAltasUsuarios=new JMenuItem("Agregar nuevo usuario");
				menuBajasUsuarios=new JMenuItem("Bajas Usuarios");
				menuEdicionUsuarios=new JMenuItem("Editar un usuario");
			menuAccionesUsuarios.add(menuAltasUsuarios);
			menuAccionesUsuarios.add(menuBajasUsuarios);
			menuAccionesUsuarios.add(menuEdicionUsuarios);
		
		
		
		//Menu item Acciones Usuarios
		
			menuAccionesLibros=new JMenu("Acciones libros");
				munuCargaBajaLibros=new JMenuItem("Cargar/Devolver libro");
				menuMostrarMovimientos=new JMenuItem("Mostrar movimientos en libros");
			menuAccionesLibros.add(munuCargaBajaLibros);
			menuAccionesLibros.add(menuMostrarMovimientos);
			
		//Agregar menuBar
		menuBar1.add(menuAccionesUsuarios);
		menuBar1.add(menuAccionesLibros);
		setJMenuBar(menuBar1);
		
			
		//----------------------------------------Eventos--------------------------------
		
		menuAltasUsuarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaAgregarUsuarios ventanitaAltas=new VentanaAgregarUsuarios();
					dp.add(ventanitaAltas);
					ventanitaAltas.setVisible(true);
					add(dp);
					
			}
		});
		menuBajasUsuarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaBajasUsuarios ventanitaBajas=new VentanaBajasUsuarios();
				dp.add(ventanitaBajas);
				ventanitaBajas.setVisible(true);
				add(dp);
				
			}
		});
		
		setLocationRelativeTo(null);
	}//Constructor
}
