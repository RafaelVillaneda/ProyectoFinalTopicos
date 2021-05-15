package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class VentanaInicio extends JFrame implements ActionListener{
	
	JMenuBar menuBar1;
	JMenu menuAccionesUsuarios,menuAccionesLibros,menuConsultas;
	JMenuItem menuAltasUsuarios,menuBajasUsuarios,menuEdicionUsuarios,menuConsultaUsuario,menuConsultasLibros;
	
	JMenuItem munuBajaLibrosMov,menuMostrarMovimientos,menuAltasLibros,menuBajasLibros,menuAltasibrosMov;
	
	JInternalFrame IF_AltasUsuarios,IF_BajasUsuarios;
	
	JDesktopPane dp=new JDesktopPane();
	ImageIcon fondo=new ImageIcon("./recursos/Fondo.png");
	JLabel lblFondo=new JLabel(fondo);
	
	
	
	public VentanaInicio() {
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Libreria los Literatos");
		setVisible(true);
		setSize(750, 500);
		this.getContentPane().setBackground(new Color(41, 184, 141));
		setResizable(false);
		
		dp.setBackground(new Color(41, 184, 141));
		
		//Menu item Acciones Usuarios
		
		menuBar1=new JMenuBar();
			menuAccionesUsuarios=new JMenu("Acciones Usuarios");
			
				menuAltasUsuarios=new JMenuItem("Agregar nuevo usuario");
				menuAltasUsuarios.addActionListener(this);
				
				menuBajasUsuarios=new JMenuItem("Bajas Usuarios");
				menuBajasUsuarios.addActionListener(this);
				
				menuEdicionUsuarios=new JMenuItem("Editar un usuario");
				menuEdicionUsuarios.addActionListener(this);
				
				
				
			menuAccionesUsuarios.add(menuAltasUsuarios);
			menuAccionesUsuarios.add(menuBajasUsuarios);
			menuAccionesUsuarios.add(menuEdicionUsuarios);
			
		
		
		
		//Menu item Acciones Usuarios
		
			menuAccionesLibros=new JMenu("Acciones libros");
			
				munuBajaLibrosMov=new JMenuItem("Devolver libro");
				munuBajaLibrosMov.addActionListener(this);
				
				menuAltasibrosMov=new JMenuItem("Rentar Libro");
				menuAltasibrosMov.addActionListener(this);
				
				menuMostrarMovimientos=new JMenuItem("Mostrar movimientos en libros");
				menuMostrarMovimientos.addActionListener(this);
				
				menuAltasLibros=new JMenuItem("Agregar libro");
				menuAltasLibros.addActionListener(this);
				
				menuBajasLibros=new JMenuItem("Eliminar libro");
				menuBajasLibros.addActionListener(this);
				
			menuAccionesLibros.add(munuBajaLibrosMov);
			menuAccionesLibros.add(menuAltasibrosMov);
			menuAccionesLibros.add(menuMostrarMovimientos);
			menuAccionesLibros.add(menuAltasLibros);
			menuAccionesLibros.add(menuBajasLibros);
		
			//Menu item Consultas
			menuConsultas =new JMenu("Consultas");
			
				menuConsultaUsuario=new JMenuItem("Consultar Usuarios");
				menuConsultaUsuario.addActionListener(this);
				
				menuConsultasLibros=new JMenuItem("Consultar Libros"); 
				menuConsultasLibros.addActionListener(this);
				menuConsultas.add(menuConsultaUsuario);
				menuConsultas.add(menuConsultasLibros);
			
		//Agregar menuBar
		menuBar1.add(menuAccionesUsuarios);
		menuBar1.add(menuAccionesLibros);
		menuBar1.add(menuConsultas);
		setJMenuBar(menuBar1);

		setLocationRelativeTo(null);
	}//Constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==menuAltasUsuarios) {//GUI completa --MYSQL
			VentanaAgregarUsuarios ventanitaAltas=new VentanaAgregarUsuarios();
			dp.add(ventanitaAltas);
			ventanitaAltas.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuBajasUsuarios) {//GUI Completa :)
			VentanaBajasUsuarios ventanitaBajas=new VentanaBajasUsuarios();
			dp.add(ventanitaBajas);
			ventanitaBajas.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuEdicionUsuarios) {//GUI completa --MYSQL
			VentanaEditarUsuario ventanaEdicion=new VentanaEditarUsuario();
			dp.add(ventanaEdicion);
			ventanaEdicion.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuAltasibrosMov) {//GUI en edicion 
			VentanaAltasLibrosMovimientos ventanaRenta=new VentanaAltasLibrosMovimientos();
			dp.add(ventanaRenta);
			ventanaRenta.setVisible(true);
			add(dp);
		}else if(e.getSource()==munuBajaLibrosMov) {
			VentanaDevolucionLibro vDev=new VentanaDevolucionLibro();
			dp.add(vDev);
			vDev.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuMostrarMovimientos) {//GUI completa
			VentanaMostrarMovimientos ventanaMovimientos=new VentanaMostrarMovimientos();
			dp.add(ventanaMovimientos);
			ventanaMovimientos.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuAltasLibros) {//GUI en edicion
			VentanaAgregarLibro ventanaGregarL=new VentanaAgregarLibro();
			dp.add(ventanaGregarL);
			ventanaGregarL.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuBajasLibros){
			VentanaEliminarLibro Veliminar=new VentanaEliminarLibro();
			dp.add(Veliminar);
			Veliminar.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuConsultaUsuario) {//GUI completa 
			ConsultaUsuario ventanita=new ConsultaUsuario();
			dp.add(ventanita);
			ventanita.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuConsultasLibros) {//GUI Completa
			VentanaConsultasLibros consulta=new VentanaConsultasLibros();
			dp.add(consulta);
			consulta.setVisible(true);
			add(dp);
		}
		
	}//Eventos
	
}//Clase
