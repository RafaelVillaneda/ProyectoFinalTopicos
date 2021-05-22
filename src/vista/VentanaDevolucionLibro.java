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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ConexionBD.ConexionBD;
import controlador.LibroDAO;
import controlador.MovimientoDAO;
import controlador.UsuarioDAO;
import modelo.Libro;
import modelo.Movimiento;
import modelo.Usuario;

public class VentanaDevolucionLibro extends JInternalFrame implements ActionListener{

	JButton btnBorrarMov,btncancelar,btnBorrar;
	JTextField cajaIDMOv;
	
	ImageIcon iconoRegresar=new ImageIcon("./recursos/Regresar.png");
	ImageIcon iconoLimpiar=new ImageIcon("./recursos/Restablecer.png");
	ImageIcon iconoBorrar=new ImageIcon("./recursos/216658.png");
	
	JTable tabla=new JTable();
	
	public VentanaDevolucionLibro() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(360, 350);
		setVisible(true);
		this.getContentPane().setBackground(new Color(48, 158, 125));
		setTitle("Devolucion de libros");
		
		setIconifiable(true);//Minimizar
		setResizable(false);//Cambiar tamaño
		//setClosable(true);//Cerrar
		
		cajaIDMOv=new JTextField(10);
		
		btnBorrarMov=new JButton();
		btncancelar=new JButton("");
		btnBorrar=new JButton("");
		
		JLabel lb1=new JLabel("ID Movimiento:");
		lb1.setBounds(20,-30,100,100);
		add(lb1);
		
		
		cajaIDMOv.setBounds(105,10,100,20);add(cajaIDMOv);

		JLabel lb2=new JLabel("--------------------------------------------------------------------------------------------------");
		lb2.setBounds(20,0,1000,100);add(lb2);
		
		btnBorrar=new JButton(iconoBorrar);
		btnBorrarMov.setIcon(new ImageIcon(iconoBorrar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnBorrarMov.setBounds(20, 90, 60, 60);add(btnBorrarMov);
		
		btnBorrar.setIcon(new ImageIcon(iconoLimpiar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnBorrar.setBounds(136, 90, 60, 60);add(btnBorrar);
		
		btncancelar.setIcon(new ImageIcon(iconoRegresar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btncancelar.setBounds(252, 90, 60, 60);add(btncancelar);add(btncancelar);
		
		JScrollPane scroll=new JScrollPane(tabla);
		scroll.setBounds(20, 175, 300, 100);add(scroll);
		actualizarTabla();
		
		btncancelar.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnBorrarMov.addActionListener(this);
		//Validar cajas
		cajaIDMOv.addKeyListener(new KeyListener() {
			
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
		MovimientoDAO mDAO=new MovimientoDAO();
		if(e.getSource()==btnBorrar) {
			restablecer(cajaIDMOv);
		}else if(e.getSource()==btncancelar) {
			setVisible(false);
		}else if(e.getSource()==btnBorrarMov) {
			if(!validarCajasVacias()) {
				boolean bandera=false;
				bandera=mDAO.eliminarRegistro(cajaIDMOv.getText());
				if(bandera) {
					JOptionPane.showMessageDialog(null,"Se elimino el registro corretamente");
					actualizarTabla();
					restablecer(cajaIDMOv);
				}else {
					JOptionPane.showMessageDialog(null,"NO se elimino el registro");	
				}
			}else {
				JOptionPane.showMessageDialog(null,"No puedes dejar campos vacios");
			}
		}
		
		
	}
	public boolean validarCajasVacias() {
		if(cajaIDMOv.getText().isEmpty()) {
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
		tabla.setModel(modeloDatos);
		//scroll.setPreferredSize( 400, 600 );
		
	}
}
