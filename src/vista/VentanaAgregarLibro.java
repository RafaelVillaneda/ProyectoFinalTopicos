package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import ConexionBD.ConexionBD;
import controlador.LibroDAO;
import modelo.Libro;

public class VentanaAgregarLibro extends JInternalFrame implements ActionListener{
	
	JTextField cajatitulo,cajaAutor,cajaEditorial,cajaGeneros;
	JButton btnAgregarLibro,btnLimpiar,btnRegresar;
	
	ImageIcon iconoRegresar=new ImageIcon("./recursos/Regresar.png");
	ImageIcon iconoLimpiar=new ImageIcon("./recursos/Restablecer.png");
	ImageIcon iconoBuscar=new ImageIcon("./recursos/lupa.png");
	ImageIcon iconAgregar=new ImageIcon("./recursos/AgregarLibro.png");
	ImageIcon iconLibro=new ImageIcon("./recursos/Libros.png");
	
	JTable tablaLibros=new JTable(5,5);
	
	public VentanaAgregarLibro() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(48, 158, 125));
		setTitle("Agregar Libro");
		
		//Incicalizar------
		
		cajatitulo=new JTextField(10);
		cajaAutor=new JTextField(10);
		cajaEditorial=new JTextField(10);
		cajaGeneros=new JTextField(10);
		
		
		
		
		//adicion
		JLabel lb1=new JLabel("ID: libro: ");
		JLabel lb2=new JLabel();
		lb2.setIcon(new ImageIcon(iconLibro.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		lb2.setBounds(200, 25, 100, 100);add(lb2);
		
		lb1=new JLabel("Titulo: ");
		lb1.setBounds(10, 10, 100, 50);add(lb1);
		cajatitulo.setBounds(60, 25, 100, 20);add(cajatitulo);
		
		lb1=new JLabel("Autor: ");
		lb1.setBounds(10, 45, 100, 50);add(lb1);
		cajaAutor.setBounds(60, 60, 100, 20);add(cajaAutor);
		
		lb1=new JLabel("Editorial: ");
		lb1.setBounds(10, 75, 100, 50);add(lb1);
		cajaEditorial.setBounds(60, 90, 100, 20);add(cajaEditorial);
		
		lb1=new JLabel("Genero: ");
		lb1.setBounds(10, 105, 100, 50);add(lb1);
		cajaGeneros.setBounds(60, 120, 100, 20);add(cajaGeneros);
		
		lb1=new JLabel("---------------------------------------------------------------------------------------");
		lb1.setBounds(0, 130, 350, 50);add(lb1);
		
		btnRegresar=new JButton(iconoRegresar);
		btnRegresar.setIcon(new ImageIcon(iconoRegresar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnRegresar.setBounds(10, 180, 50, 50);add(btnRegresar);
		
		btnAgregarLibro=new JButton(iconAgregar);
		btnAgregarLibro.setIcon(new ImageIcon(iconAgregar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnAgregarLibro.setBounds(140, 180, 50, 50);add(btnAgregarLibro);
		
		btnLimpiar=new JButton(iconoLimpiar);
		btnLimpiar.setIcon(new ImageIcon(iconoLimpiar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnLimpiar.setBounds(275, 180, 50, 50);add(btnLimpiar);
		
		
		
		actualizarTabla();
		JScrollPane scroll=new JScrollPane(tablaLibros);
		scroll.setBounds(10, 250, 325, 100);add(scroll);
		
		//VALIDACION
		
		cajaAutor.addKeyListener(new KeyListener() {
			
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
		cajaEditorial.addKeyListener(new KeyListener() {
			
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
		cajaGeneros.addKeyListener(new KeyListener() {
			
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
		cajatitulo.addKeyListener(new KeyListener() {
			
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
		
		
		//Evetos
		btnAgregarLibro.addActionListener(this);
		btnLimpiar.addActionListener(this);
		btnRegresar.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAgregarLibro) {
			Libro libro=new Libro(cajatitulo.getText(), cajaGeneros.getText(), cajaAutor.getText(), cajaEditorial.getText(),0);
			ConexionBD.AgregarRegistroTablaLibros(libro);
			actualizarTabla();
		}else if(e.getSource()==btnLimpiar) {
			restablecer(cajaAutor,cajaEditorial,cajaGeneros,cajatitulo);
		}else if(e.getSource()==btnRegresar) {
			setVisible(false);
		}
		
	}
	public void actualizarTabla() {
		
		String controlador = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/libreria";
		String consulta = "SELECT * FROM libros";
		
		ResultSetTableModel modeloDatos=null;
		try {
			modeloDatos = new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		tablaLibros.setModel(modeloDatos);
	}
	
	public void restablecer(Component...ComonentesGraficos){
		
		for (Component Component : ComonentesGraficos) {
			if(Component instanceof JComboBox) {
				((JComboBox<?>)Component).setSelectedIndex(0);
			}else if(Component instanceof JTextField) {
				((JTextField)Component).setText("");
			}else if(Component instanceof JSpinner) {
				((JSpinner)Component).setValue(0);;
			}
		}
		
	}//Restablecer
	
	
	
	
}
