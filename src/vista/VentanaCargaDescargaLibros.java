package vista;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaCargaDescargaLibros extends JInternalFrame{
	
	JButton btnCargarLibro,btnDevolverLibro,btncancelar,btnBorrar;
	JRadioButton radiokAgregarLibro,radioDevolverLibro;
	JTextField cajaIdLibro,cajaIdUsuario;
	
	public VentanaCargaDescargaLibros() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 250);
		setVisible(true);
		this.getContentPane().setBackground(new Color(147, 192, 244));
		setTitle("Renta/Devolucion libros");
		
		setIconifiable(true);//Minimizar
		setResizable(true);//Cambiar tamaño
		setClosable(true);//Cerrar
		
		cajaIdLibro=new JTextField(10);
		cajaIdLibro=new JTextField(10);
		cajaIdUsuario=new JTextField(10);
		
		btnCargarLibro=new JButton("Rentar Libro");
		btnDevolverLibro=new JButton("Devolver libro");
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
		
		
		
	}
}
