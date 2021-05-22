package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import ConexionBD.ConexionBD;
import controlador.LibroDAO;
import controlador.UsuarioDAO;
import modelo.Libro;
import modelo.Movimiento;
import modelo.Usuario;

public class VentanaAltasLibrosMovimientos extends JInternalFrame implements ActionListener{
	
	JButton btnAgregarMov,btncancelar,btnBorrar;
	JTextField cajaIdLibro,cajaIdUsuario;
	
	ImageIcon iconoRegresar=new ImageIcon("./recursos/Regresar.png");
	ImageIcon iconoLimpiar=new ImageIcon("./recursos/Restablecer.png");
	ImageIcon iconoAgregar=new ImageIcon("./recursos/AgregarLibro.png");
	
	JTable tablaMov=new JTable();
	
	public VentanaAltasLibrosMovimientos() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(48, 158, 125));
		setTitle("Renta libros");
		
		setIconifiable(true);//Minimizar
		setResizable(false);//Cambiar tamaño
		//setClosable(true);//Cerrar
		
		cajaIdLibro=new JTextField(10);
		cajaIdLibro=new JTextField(10);
		cajaIdUsuario=new JTextField(10);
		
		btnAgregarMov=new JButton();
		btncancelar=new JButton("");
		btnBorrar=new JButton("");
		
		JLabel lb1=new JLabel("ID libro:");
		lb1.setBounds(20,-30,100,100);
		add(lb1);
		
		
		cajaIdLibro.setBounds(95,10,100,20);add(cajaIdLibro);

		JLabel lb2=new JLabel("ID Usuario:");
		lb2.setBounds(20,0,100,100);add(lb2);
		
		cajaIdUsuario.setBounds(95, 40, 110, 20);add(cajaIdUsuario);
		
		btnBorrar=new JButton(iconoAgregar);
		btnAgregarMov.setIcon(new ImageIcon(iconoAgregar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnAgregarMov.setBounds(20, 90, 60, 60);add(btnAgregarMov);
		
		btnBorrar.setIcon(new ImageIcon(iconoLimpiar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnBorrar.setBounds(100, 90, 60, 60);add(btnBorrar);
		
		btncancelar.setIcon(new ImageIcon(iconoRegresar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btncancelar.setBounds(180, 90, 60, 60);add(btncancelar);add(btncancelar);
		
		
		btncancelar.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnAgregarMov.addActionListener(this);
		
		actualizarTabla();
		JScrollPane scroll=new JScrollPane(tablaMov);
		scroll.setBounds(10, 190, 250, 100);add(scroll);
		
		//Validar cajas
		cajaIdLibro.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car)){}else{
				e.consume();
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
		if(e.getSource()==btnBorrar) {
			restablecer(cajaIdLibro,cajaIdUsuario);
		}else if(e.getSource()==btncancelar) {
			setVisible(false);
		}else if(e.getSource()==btnAgregarMov) {
			if(!validarCajasVacias()) {
				Libro libritoLibro=lDAO.buscar(Integer.parseInt(cajaIdLibro.getText()));
				if(libritoLibro!=null){
					Usuario usu=uDAO.buscar(Integer.parseInt(cajaIdUsuario.getText()));
					if(usu!=null) {
						boolean agregado=ConexionBD.AgregarRegistroTablaMovimientos(new Movimiento(0, libritoLibro.getIDLibro(), usu.getId(), null));      
						if (agregado) {
							JOptionPane.showMessageDialog(null,"El libro se rento con exito");
						}
					}else {
						JOptionPane.showMessageDialog(null,"Usuario no encontrado");
					}
				}else {
					JOptionPane.showMessageDialog(null,"Libro no encontrado");
				}
			}else {
				JOptionPane.showMessageDialog(null,"No puedes dejar campos vacios");
			}
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
public void actualizarTabla() {
		
		String controlador = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/libreria";
		String consulta = "SELECT id_movimiento,id_libro,id_usuario,DATE(fecha) AS fecha FROM movimientos";
		
		ResultSetTableModel modeloDatos=null;
		
		try {
			modeloDatos = new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		tablaMov.setModel(modeloDatos);
		//scroll.setPreferredSize( 400, 600 );
		
	}
	
}
