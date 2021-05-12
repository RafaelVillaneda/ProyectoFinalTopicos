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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VentanaConsultasLibros extends JInternalFrame implements ActionListener{
	
	JTextField cajatitulo,cajaAutor,cajaEditorial,cajaGeneros,cajaId;
	JButton btnBuscar,btnLimpiar,btnRegresar;
	
	ImageIcon iconoRegresar=new ImageIcon("./recursos/Regresar.png");
	ImageIcon iconoLimpiar=new ImageIcon("./recursos/Restablecer.png");
	ImageIcon iconoBuscar=new ImageIcon("./recursos/lupa.png");
	
	JTable tablaLibros=new JTable(5,5);
	String vec[]={"Selecciona una opcion","ID libro:","Autor:","Editorial:","Genero:","Titulo:","Todos"};
	byte seleccion=0;
	JComboBox<String> comboBusquedas=new JComboBox<String>(vec);
	
	public VentanaConsultasLibros() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(425, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(48, 158, 125));
		setTitle("Consultas Libros");
		
		//Incicalizar------
		
		cajatitulo=new JTextField(10);
		cajaAutor=new JTextField(10);
		cajaEditorial=new JTextField(10);
		cajaGeneros=new JTextField(10);
		cajaId=new JTextField(10);
		
		btnBuscar=new JButton(iconoBuscar);btnBuscar.setEnabled(false);
		btnBuscar.setIcon(new ImageIcon(iconoBuscar.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH)));
		
		//adicion
		JLabel lb1=new JLabel("ID: libro: ");
		lb1.setBounds(10, 0, 100, 50);add(lb1);
		cajaId.setBounds(60, 15, 100, 20);add(cajaId);cajaId.setEnabled(false);
		btnBuscar.setBounds(175, 5, 40, 40);add(btnBuscar);
		
		comboBusquedas.setBounds(250, 5, 150, 30);add(comboBusquedas);comboBusquedas.addActionListener(this);
		
		lb1=new JLabel("---------------------------------------------------------------------------------------");
		lb1.setBounds(0, 25, 350, 50);add(lb1);
		
		lb1=new JLabel("Titulo: ");
		lb1.setBounds(10, 50, 100, 50);add(lb1);
		cajatitulo.setBounds(60, 65, 100, 20);add(cajatitulo);cajatitulo.setEnabled(false);
		
		lb1=new JLabel("Autor: ");
		lb1.setBounds(10, 85, 100, 50);add(lb1);
		cajaAutor.setBounds(60, 100, 100, 20);add(cajaAutor);cajaAutor.setEnabled(false);
		
		lb1=new JLabel("Editorial: ");
		lb1.setBounds(175, 65, 100, 50);add(lb1);
		cajaEditorial.setBounds(230, 80, 100, 20);add(cajaEditorial);cajaEditorial.setEnabled(false);
		
		lb1=new JLabel("Genero: ");
		lb1.setBounds(175, 115, 100, 50);add(lb1);
		cajaGeneros.setBounds(230, 130, 100, 20);add(cajaGeneros);cajaGeneros.setEnabled(false);
		
		lb1=new JLabel("---------------------------------------------------------------------------------------");
		lb1.setBounds(0, 145, 350, 50);add(lb1);
		
		btnRegresar=new JButton(iconoRegresar);
		btnRegresar.setIcon(new ImageIcon(iconoRegresar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnRegresar.setBounds(10, 180, 50, 50);add(btnRegresar);
		
		btnLimpiar=new JButton(iconoLimpiar);
		btnLimpiar.setIcon(new ImageIcon(iconoLimpiar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnLimpiar.setBounds(275, 180, 50, 50);add(btnLimpiar);
		
		
		actualizarTabla();
		JScrollPane scroll=new JScrollPane(tablaLibros);
		scroll.setBounds(10, 250, 325, 100);add(scroll);
		
		//VALIDACION
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
		
		btnBuscar.addActionListener(this);
		btnLimpiar.addActionListener(this);
		btnRegresar.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			actualizarTabla();
		}else if(e.getSource()==btnLimpiar) {
			restablecer(cajaAutor,cajaEditorial,cajaGeneros,cajaId,cajatitulo);
		}else if(e.getSource()==btnRegresar) {
			setVisible(false);
		}else if(e.getSource()==comboBusquedas) {
			if(comboBusquedas.getSelectedIndex()==1) {
				seleccion=1;
				btnBuscar.setEnabled(true);
				cajaId.setEnabled(true);
				cajaAutor.setEnabled(false);
				cajaEditorial.setEnabled(false);
				cajaGeneros.setEnabled(false);
				cajatitulo.setEnabled(false);
				System.out.println(seleccion+"-->"+comboBusquedas.getSelectedItem());
			}else if(comboBusquedas.getSelectedIndex()==2) {
				seleccion=2;
				btnBuscar.setEnabled(true);
				cajaId.setEnabled(false);
				cajaAutor.setEnabled(true);
				cajaEditorial.setEnabled(false);
				cajaGeneros.setEnabled(false);
				cajatitulo.setEnabled(false);
				System.out.println(seleccion+"-->"+comboBusquedas.getSelectedItem());
			}else if(comboBusquedas.getSelectedIndex()==3) {
				seleccion=3;
				btnBuscar.setEnabled(true);
				cajaId.setEnabled(false);
				cajaAutor.setEnabled(false);
				cajaEditorial.setEnabled(true);
				cajaGeneros.setEnabled(false);
				cajatitulo.setEnabled(false);
				System.out.println(seleccion+"-->"+comboBusquedas.getSelectedItem());
			}else if(comboBusquedas.getSelectedIndex()==4) {
				seleccion=4;
				btnBuscar.setEnabled(true);
				cajaId.setEnabled(false);
				cajaAutor.setEnabled(false);
				cajaEditorial.setEnabled(false);
				cajaGeneros.setEnabled(true);
				cajatitulo.setEnabled(false);
				System.out.println(seleccion+"-->"+comboBusquedas.getSelectedItem());
			}else if(comboBusquedas.getSelectedIndex()==5) {
				seleccion=5;
				btnBuscar.setEnabled(true);
				cajaId.setEnabled(false);
				cajaAutor.setEnabled(false);
				cajaEditorial.setEnabled(false);
				cajaGeneros.setEnabled(false);
				cajatitulo.setEnabled(true);
				System.out.println(seleccion+"-->"+comboBusquedas.getSelectedItem());
			}else if(comboBusquedas.getSelectedIndex()==0) {
				seleccion=0;
				btnBuscar.setEnabled(false);
				cajaId.setEnabled(false);
				cajaAutor.setEnabled(false);
				cajaEditorial.setEnabled(false);
				cajaGeneros.setEnabled(false);
				cajatitulo.setEnabled(false);
				System.out.println(seleccion+"-->"+comboBusquedas.getSelectedItem());
				actualizarTabla();
			}else if(comboBusquedas.getSelectedIndex()==6) {
				seleccion=6;
				btnBuscar.setEnabled(true);
				cajaId.setEnabled(true);
				cajaAutor.setEnabled(true);
				cajaEditorial.setEnabled(true);
				cajaGeneros.setEnabled(true);
				cajatitulo.setEnabled(true);
				System.out.println(seleccion+"-->"+comboBusquedas.getSelectedItem());
			}
		}
		
	}
	
	public void actualizarTabla() {
		String controlador = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/libreria";
		String consulta = "SELECT * FROM libros";
		
		ResultSetTableModel modeloDatos=null;
		//"Selecciona una opcion","ID libro:","Autor:","Editorial:","Genero:","Titulo:","Todos"};
		if(seleccion==6) {
			int id=-1;
			if(cajaId.getText()!="") {
			id=Integer.parseInt(cajaId.getText());
			}
			consulta ="SELECT * FROM libros WHERE id_libro="+id+" AND nombre='"+cajatitulo.getText()+"' AND genero='"+cajaGeneros.getText()+"'"
					+ "AND autor = '"+cajaAutor.getText()+"' AND editorial = '"+cajaEditorial.getText()+"';";
		}else if(seleccion==1) {
			int id=-1;
			if(cajaId.getText()!="") {
			id=Integer.parseInt(cajaId.getText());
			}
			consulta ="SELECT * FROM libros WHERE id_libro="+id+";";
		}else if(seleccion==2) {
			consulta ="SELECT * FROM libros WHERE autor='"+cajaAutor.getText()+"';";
		}else if(seleccion==3) {
			consulta ="SELECT * FROM libros WHERE editorial='"+cajaEditorial.getText()+"';";
		}else if(seleccion==4) {
			consulta ="SELECT * FROM libros WHERE genero='"+cajaGeneros.getText()+"';";
		}else if(seleccion==5) {
			consulta ="SELECT * FROM libros WHERE nombre='"+cajaAutor.getText()+"';";
		}
		
		try {
			modeloDatos = new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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
