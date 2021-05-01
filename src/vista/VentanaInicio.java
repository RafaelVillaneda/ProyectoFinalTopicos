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
	JMenu menuAccionesUsuarios,menuAccionesLibros;
	JMenuItem menuAltasUsuarios,menuBajasUsuarios,menuEdicionUsuarios,menuConsultaUsuario;
	
	JMenuItem munuCargaBajaLibros,menuMostrarMovimientos,menuAltasBajasLibros;
	
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
				
				menuConsultaUsuario=new JMenuItem("Consultar Usuarios");
				menuConsultaUsuario.addActionListener(this);
				
			menuAccionesUsuarios.add(menuAltasUsuarios);
			menuAccionesUsuarios.add(menuBajasUsuarios);
			menuAccionesUsuarios.add(menuEdicionUsuarios);
			menuAccionesUsuarios.add(menuConsultaUsuario);
		
		
		
		//Menu item Acciones Usuarios
		
			menuAccionesLibros=new JMenu("Acciones libros");
			
				munuCargaBajaLibros=new JMenuItem("Cargar/Devolver libro");
				munuCargaBajaLibros.addActionListener(this);
				
				menuMostrarMovimientos=new JMenuItem("Mostrar movimientos en libros");
				menuMostrarMovimientos.addActionListener(this);
				
				menuAltasBajasLibros=new JMenuItem("Agregar libro/ Eliminar libro");
				menuAltasBajasLibros.addActionListener(this);
				
			menuAccionesLibros.add(munuCargaBajaLibros);
			menuAccionesLibros.add(menuMostrarMovimientos);
			menuAccionesLibros.add(menuAltasBajasLibros);
			
		//Agregar menuBar
		menuBar1.add(menuAccionesUsuarios);
		menuBar1.add(menuAccionesLibros);
		setJMenuBar(menuBar1);

		setLocationRelativeTo(null);
	}//Constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==menuAltasUsuarios) {//GUI completa 
			VentanaAgregarUsuarios ventanitaAltas=new VentanaAgregarUsuarios();
			dp.add(ventanitaAltas);
			ventanitaAltas.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuBajasUsuarios) {//GUI Completa :)
			VentanaBajasUsuarios ventanitaBajas=new VentanaBajasUsuarios();
			dp.add(ventanitaBajas);
			ventanitaBajas.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuEdicionUsuarios) {//GUI completa 
			VentanaEditarUsuario ventanaEdicion=new VentanaEditarUsuario();
			dp.add(ventanaEdicion);
			ventanaEdicion.setVisible(true);
			add(dp);
		}else if(e.getSource()==munuCargaBajaLibros) {//GUI en edicion 
			VentanaCargaDescargaLibros ventanaRenta=new VentanaCargaDescargaLibros();
			dp.add(ventanaRenta);
			ventanaRenta.setVisible(true);
			add(dp);
		}else if(e.getSource()==menuMostrarMovimientos) {//Sin configurar
			
		}else if(e.getSource()==menuAltasBajasLibros) {//Sin configurar
			
		}else if(e.getSource()==menuConsultaUsuario) {//En proceso
			ConsultaUsuario ventanita=new ConsultaUsuario();
			dp.add(ventanita);
			ventanita.setVisible(true);
			add(dp);
		}
		
	}//Eventos
	
}//Clase
