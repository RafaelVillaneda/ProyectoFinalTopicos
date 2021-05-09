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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.UsuarioDAO;
import modelo.Usuario;

public class VentanaAgregarUsuarios extends JInternalFrame implements ActionListener{

	JTextField cajaNombre,cajaPrimerAp,cajaSegundoAp,cajaCorreo,cajaId;
	JButton btnAlta,btnCancelar,btnLimpiar;
	
	ImageIcon iconoAlta=new ImageIcon("./recursos/Agregar.png");
	ImageIcon iconoRegresar=new ImageIcon("./recursos/Regresar.png");
	ImageIcon iconoBorrar=new ImageIcon("./recursos/Restablecer.png");
	ImageIcon iconoBuscar=new ImageIcon("./recursos/lupa.png");
	
	JTable tabla=new JTable();
	UsuarioDAO uDAO=new UsuarioDAO();
	public VentanaAgregarUsuarios() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(270, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(48, 158, 125));
		setTitle("Agregar Usuario");
		
		
		//Inicializar componentes
		cajaId=new JTextField(10);
		cajaNombre=new JTextField(10);
		cajaPrimerAp=new JTextField(10);
		cajaSegundoAp=new JTextField(10);
		cajaCorreo=new JTextField(10);
		
		
		JLabel lb2=new JLabel("-------------------------Datos-----------------------");
		lb2.setBounds(1,25, 250, 20);add(lb2);
		
		JLabel lb3=new JLabel("Nombre:");
		lb3.setBounds(1,45, 100, 20);add(lb3);
		cajaNombre.setBounds(120, 45, 100, 20);add(cajaNombre);
		
		JLabel lb4=new JLabel("Apellido Paterno: ");
		lb4.setBounds(1,75, 100, 20);add(lb4);
		cajaPrimerAp.setBounds(120,75, 100, 20);add(cajaPrimerAp);
		
		JLabel lb5=new JLabel("Apellido Materno: ");
		lb5.setBounds(1,105, 110, 20);add(lb5);
		cajaSegundoAp.setBounds(120,105, 100, 20);add(cajaSegundoAp);
		
		JLabel lb6=new JLabel("Correo electronico: ");
		lb6.setBounds(1,135, 150, 20);add(lb6);
		cajaCorreo.setBounds(120,135, 100, 20);add(cajaCorreo);
		
		JLabel lb7=new JLabel("------------------------------------------------------");
		lb7.setBounds(1,165, 250, 20);add(lb7);
		//Iconos botones
		btnAlta=new JButton(iconoAlta);
		btnAlta.setIcon(new ImageIcon(iconoAlta.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnAlta.setBounds(1, 200,50, 60);add(btnAlta);
		
		btnLimpiar=new JButton(iconoBorrar);
		btnLimpiar.setIcon(new ImageIcon(iconoBorrar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnLimpiar.setBounds(90, 200,50, 60);add(btnLimpiar);
		
		btnCancelar=new JButton(iconoRegresar);
		btnCancelar.setIcon(new ImageIcon(iconoRegresar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnCancelar.setBounds(180, 200,50, 60);add(btnCancelar);
		
		
		
		//Eventos
		btnLimpiar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnAlta.addActionListener(this);
		//Validacion
		
		cajaNombre.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isLetter(car) || Character.isSpaceChar(car)){
					//String cadena=txtNombre.getText();
					//txtNumControl.setText(cadena+e);
				}else{
				e.consume();
				getToolkit().beep();
				}
			}
			@Override public void keyPressed(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
		});
		
		cajaPrimerAp.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isLetter(car) || Character.isSpaceChar(car)){
					//String cadena=txtNombre.getText();
					//txtNumControl.setText(cadena+e);
				}else{
				e.consume();
				getToolkit().beep();
				}
			}
			@Override public void keyPressed(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
		});
		
		cajaSegundoAp.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isLetter(car) || Character.isSpaceChar(car)){
					//String cadena=txtNombre.getText();
					//txtNumControl.setText(cadena+e);
				}else{
				e.consume();
				getToolkit().beep();
				}
			}
			@Override public void keyPressed(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
		});
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLimpiar) {
			restablecer(cajaCorreo,cajaId,cajaNombre,cajaPrimerAp,cajaSegundoAp);
		}else if(e.getSource()==btnCancelar) {
			setVisible(false);
		}else if(e.getSource()==btnAlta) {
			if(validarCajasVacias()) {
				Usuario u=new Usuario();
				u.setCorreo(cajaCorreo.getText());
				u.setNombre(cajaNombre.getText());
				u.setPrimerAp(cajaPrimerAp.getText());
				u.setSegundoAp(cajaSegundoAp.getText());
				if(uDAO.insertarRegistro(u)) {
					JOptionPane.showMessageDialog(null,"Se agrego el usuario correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"NO SE AGREGO EL USUARIO");
				}
			}else {
				JOptionPane.showMessageDialog(null,"Debes de llenar todos los datos!");
			}
		}
		
	}
	public boolean validarCajasVacias() {
		if(cajaNombre.getText().isEmpty()) {
			return false;
		}else if(cajaSegundoAp.getText().isEmpty()) {
			return false;
		}else if(cajaPrimerAp.getText().isEmpty()) {
			return false;
		}else if(cajaCorreo.getText().isEmpty()) {
			return false;
		}
		return true;
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
	
	
		public void actualizarTabla() {
			
			String controlador = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/libreria";
			String consulta = "SELECT * FROM usuario_cliente";
			
			ResultSetTableModel modeloDatos=null;
			try {
				modeloDatos = new ResultSetTableModel(controlador, url, consulta);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			tabla.setModel(modeloDatos);
			//scroll.setPreferredSize( 400, 600 );
			
		}
		
	}

