package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VentanaAgregarUsuarios extends JInternalFrame implements ActionListener{
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JTextField cajaNombre,cajaPrimerAp,cajaSegundoAp,cajaCorreo;
	JButton btnAgregar,btnBorrar,btnCancelar;
	
	ImageIcon iconoBotonAdd=new ImageIcon("./recursos/Agregar.png");
	
	JTable tabla=new JTable(3, 3);
		public VentanaAgregarUsuarios() {
			getContentPane().setLayout(gbl);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.getContentPane().setBackground(new Color(147, 192, 244));
			setTitle("Agregar Usuario");
			setResizable(false);
			setVisible(true);
			
			setIconifiable(true);//Minimizar
			setResizable(true);//Cambiar tamaño
			setClosable(true);//Cerrar
			
			//Inicializar cajas
			
			cajaNombre=new JTextField(10);
			cajaPrimerAp=new JTextField(10);
			cajaSegundoAp=new JTextField(10);
			cajaCorreo=new JTextField(10);
			
			//Inicializar botones
			
			btnAgregar=new JButton("Agregar");
			btnBorrar=new JButton("Borrar");
			btnCancelar=new JButton("Cancelar");
			
			
			
			//Agregar Eventos-----------------
			
			btnAgregar.addActionListener(this);
			btnBorrar.addActionListener(this);
			btnCancelar.addActionListener(this);
			
			//-------Agregado de componentes---------
			alinear(0, 1, 2, 1, new JLabel("Nombre:"));
			alinear(2, 1, 2, 1, cajaNombre);
			
			alinear(0, 4, 2, 1, new JLabel("Apellido materno:"));
			alinear(2, 4, 2, 1, cajaPrimerAp);
			
			alinear(0, 5, 2, 1, new JLabel("Apellido paterno:"));
			alinear(2, 5, 2, 1, cajaSegundoAp);
			
			alinear(0, 7, 2, 1, new JLabel("Correo elctronico"));
			alinear(2, 7, 2, 1, cajaCorreo);
			
			alinear(0, 8, 1, 2,btnAgregar);
			alinear(2, 8, 1, 2, btnBorrar);
			alinear(3, 8, 1, 2, btnCancelar);
			
			alinear(0, 10, 3,1, tabla);
			
			
			pack();
		}
		public void alinear(int x, int y, int largo, int alto, Component componente) {
		    
			gbc.gridx = x;
			gbc.gridy = y;
			gbc.gridheight = alto;
			gbc.gridwidth = largo;
			
			gbc.anchor = GridBagConstraints.WEST;
	 
			gbl.setConstraints(componente, gbc);
			add(componente);
			
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnAgregar) {
				//Codigo para agregar
			}else if(e.getSource()==btnBorrar) {
				restablecer(cajaCorreo,cajaNombre,cajaPrimerAp,cajaSegundoAp);
			}else if(e.getSource()==btnCancelar){
				setVisible(false);
			}
			
		}
		public void restablecer(Component...ComonentesGraficos){
			
			for (Component Component : ComonentesGraficos) {
				if(Component instanceof JComboBox) {
					((JComboBox<?>)Component).setSelectedIndex(0);
				}else if(Component instanceof JTextField) {
					((JTextField)Component).setText("");
				}
			}
			
		}//Restablecer
		
	}

