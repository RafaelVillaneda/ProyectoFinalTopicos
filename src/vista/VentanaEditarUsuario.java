package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexionBD.ConexionBD;
import controlador.UsuarioDAO;
import modelo.Usuario;
import modelo.UsuarioAdministrador;

public class VentanaEditarUsuario extends JInternalFrame implements ActionListener{
	
	JTextField cajaNombre,cajaPrimerAp,cajaSegundoAp,cajaCorreo,cajaId;
	JButton btnRescribir,btnCancelar,btnLimpiar,btnBuscar;
	
	ImageIcon iconoRescribir=new ImageIcon("./recursos/Rescribir.png");
	ImageIcon iconoRegresar=new ImageIcon("./recursos/Regresar.png");
	ImageIcon iconoBorrar=new ImageIcon("./recursos/Restablecer.png");
	ImageIcon iconoBuscar=new ImageIcon("./recursos/lupa.png");
	
	UsuarioDAO uDAO=new UsuarioDAO();
	public VentanaEditarUsuario() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(270, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(48, 158, 125));
		setTitle("Editar Usuario");
		
		setIconifiable(true);//Minimizar
		setResizable(true);//Cambiar tamaño
		setClosable(true);//Cerrar
		
		//Inicializar componentes
		cajaId=new JTextField(10);
		cajaNombre=new JTextField(10);
		cajaPrimerAp=new JTextField(10);
		cajaSegundoAp=new JTextField(10);
		cajaCorreo=new JTextField(10);
		
		//Agregado
		JLabel lb1=new JLabel("ID. Usuario: ");
		lb1.setBounds(1, 0, 100, 20);add(lb1);
		cajaId.setBounds(90, 0, 100, 20);add(cajaId);
		
		btnBuscar=new JButton(iconoBuscar);
		btnBuscar.setIcon(new ImageIcon(iconoBuscar.getImage().getScaledInstance(10,10, Image.SCALE_SMOOTH)));
		btnBuscar.setBounds(200, 0,50, 30);add(btnBuscar);
		
		JLabel lb2=new JLabel("-------------------------Datos-----------------------");
		lb2.setBounds(1,25, 250, 20);add(lb2);
		
		JLabel lb3=new JLabel("Nombre:");
		lb3.setBounds(1,45, 100, 20);add(lb3);
		cajaNombre.setBounds(120, 45, 100, 20);add(cajaNombre);cajaNombre.setEditable(false);
		
		JLabel lb4=new JLabel("Apellido Paterno: ");
		lb4.setBounds(1,75, 100, 20);add(lb4);
		cajaPrimerAp.setBounds(120,75, 100, 20);add(cajaPrimerAp);cajaPrimerAp.setEditable(false);
		
		JLabel lb5=new JLabel("Apellido Materno: ");
		lb5.setBounds(1,105, 110, 20);add(lb5);
		cajaSegundoAp.setBounds(120,105, 100, 20);add(cajaSegundoAp);cajaSegundoAp.setEditable(false);
		
		JLabel lb6=new JLabel("Correo electronico: ");
		lb6.setBounds(1,135, 150, 20);add(lb6);
		cajaCorreo.setBounds(120,135, 100, 20);add(cajaCorreo);cajaCorreo.setEditable(false);
		
		JLabel lb7=new JLabel("------------------------------------------------------");
		lb7.setBounds(1,165, 250, 20);add(lb7);
		//Iconos botones
		btnRescribir=new JButton(iconoRescribir);
		btnRescribir.setIcon(new ImageIcon(iconoRescribir.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnRescribir.setBounds(1, 200,50, 60);add(btnRescribir);
		
		btnLimpiar=new JButton(iconoBorrar);
		btnLimpiar.setIcon(new ImageIcon(iconoBorrar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnLimpiar.setBounds(90, 200,50, 60);add(btnLimpiar);
		
		btnCancelar=new JButton(iconoRegresar);
		btnCancelar.setIcon(new ImageIcon(iconoRegresar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnCancelar.setBounds(180, 200,50, 60);add(btnCancelar);
		
		//Eventos
		btnRescribir.setEnabled(false);
		btnRescribir.addActionListener(this);
		btnLimpiar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
		//Validaiones cajas
		
		cajaId.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car)){
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
		
		
	}//Constuctor
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			Usuario u2=uDAO.buscar(Integer.parseInt(cajaId.getText()));
			
			if(u2!=null) {
				cajaCorreo.setEditable(true);
				cajaNombre.setEditable(true);
				cajaPrimerAp.setEditable(true);
				cajaSegundoAp.setEditable(true);
				
				cajaCorreo.setText(u2.getCorreo());
				cajaNombre.setText(u2.getNombre());
				cajaPrimerAp.setText(u2.getPrimerAp());
				cajaSegundoAp.setText(u2.getSegundoAp());
				btnRescribir.setEnabled(true);
				
			}
			
		}else if(e.getSource()==btnLimpiar) {
			restablecer(cajaCorreo,cajaId,cajaNombre,cajaPrimerAp,cajaSegundoAp);
		}else if(e.getSource()==btnRescribir) {
			Usuario usuario=new Usuario();
			if(validarCajasVacias()) {
			usuario.setId(Integer.parseInt(cajaId.getText()));
			usuario.setCorreo(cajaCorreo.getText());
			usuario.setNombre(cajaNombre.getText());
			usuario.setPrimerAp(cajaPrimerAp.getText());
			usuario.setSegundoAp(cajaSegundoAp.getText());
			
				if(uDAO.modificarUsuario(usuario)) {
					JOptionPane.showMessageDialog(null,"Registro actualizado");
				}else {
					JOptionPane.showMessageDialog(null,"Registro NO actualizado");
				}
			}else {
				JOptionPane.showMessageDialog(null,"Llena todos los datos");
			}
			
		}else if(e.getSource()==btnCancelar) {
			setVisible(false);
		}
		
	}
	public boolean validarCajasVacias() {
		if(cajaId.getText().isEmpty()) {
			return false;
		}else if(cajaNombre.getText().isEmpty()) {
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
	
	
}