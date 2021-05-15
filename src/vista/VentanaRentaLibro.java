package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ConexionBD.ConexionBD;
import controlador.LibroDAO;
import controlador.UsuarioDAO;
import modelo.Libro;
import modelo.Movimiento;
import modelo.Usuario;

public class VentanaRentaLibro extends JInternalFrame implements ActionListener{
	JButton btnCargarLibro,btncancelar,btnBorrar;
	JRadioButton radiokAgregarLibro,radioDevolverLibro;
	JTextField cajaIdLibro,cajaIdUsuario;
	
	public VentanaRentaLibro() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 250);
		setVisible(true);
		this.getContentPane().setBackground(new Color(48, 158, 125));
		setTitle("Renta/Devolucion libros");
		
		setIconifiable(true);//Minimizar
		setResizable(true);//Cambiar tamaño
		//setClosable(true);//Cerrar
		
		cajaIdLibro=new JTextField(10);
		cajaIdLibro=new JTextField(10);
		cajaIdUsuario=new JTextField(10);
		
		btnCargarLibro=new JButton("Rentar Libro");
		btncancelar=new JButton("Cancelar");
		btnBorrar=new JButton("Borrar");
		
		JLabel lb1=new JLabel("ID libro:");
		lb1.setBounds(50,0,100,100);
		add(lb1);
		
		
		cajaIdLibro.setBounds(100,40,100,20);
		add(cajaIdLibro);
		
		ButtonGroup bg=new ButtonGroup();
		radiokAgregarLibro=new JRadioButton("Agregar Libro");
		radioDevolverLibro=new JRadioButton("Devolver libro");
		
		bg.add(radiokAgregarLibro);
		bg.add(radioDevolverLibro);
		
		radiokAgregarLibro.setBounds(50, 65, 110, 20);add(radiokAgregarLibro);
		radioDevolverLibro.setBounds(160,65, 110, 20);add(radioDevolverLibro);
		
		JLabel lb2=new JLabel("ID Usuario:");
		lb2.setBounds(50,65,100,100);add(lb2);
		
		cajaIdUsuario.setBounds(120, 106, 110, 20);add(cajaIdUsuario);
		
		btnCargarLibro.setBounds(0, 150, 110, 20);add(btnCargarLibro);
		btnBorrar.setBounds(115, 150, 80, 20);add(btnBorrar);
		btncancelar.setBounds(200, 150, 100, 20);add(btncancelar);
		
		
		radioDevolverLibro.addActionListener(this);
		radiokAgregarLibro.addActionListener(this);
		btnCargarLibro.addActionListener(this);
		btncancelar.addActionListener(this);
		btncancelar.addActionListener(this);
		//Validar cajas
		cajaIdLibro.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car)){}else{
				e.consume();
				getToolkit().beep();
				}
			}
			@Override public void keyPressed(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
		});
		
		cajaIdUsuario.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car)){}else{
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
		LibroDAO lDAO=new LibroDAO();
		UsuarioDAO uDAO=new UsuarioDAO();
		if(e.getSource()==radiokAgregarLibro) {
			Libro librito;
			Usuario usu;
			if(validarCajasVacias()==false) {
				 librito=lDAO.buscar(Integer.parseInt(cajaIdLibro.getText()));
				 usu=uDAO.buscar(Integer.parseInt(cajaIdUsuario.getText()));
				 if(usu!=null) {
					 Movimiento m=new Movimiento(0, librito.getIDLibro(), usu.getId(), null);
					 ConexionBD.AgregarRegistroTablaMovimientos(m);
				 }
			}else {
				JOptionPane.showMessageDialog(null,"No puedes dejar campos vacios");
			}
			
			
		}else if(e.getSource()==btnCargarLibro) {
			//Codigo para cargar libro a un usuario
		}else if(e.getSource()==btnBorrar) {
			restablecer(cajaIdLibro,cajaIdUsuario);
		}else if(e.getSource()==btncancelar) {
			setVisible(false);
		}
		
		
	}
	public boolean validarCajasVacias() {
		if(cajaIdLibro.getText().isEmpty()) {
			return true;
		}else if(cajaIdUsuario.getText().isEmpty()) {
			return true;
		}
		return false;
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
