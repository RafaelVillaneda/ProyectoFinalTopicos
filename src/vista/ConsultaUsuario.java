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
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import ConexionBD.ConexionBD;
import controlador.UsuarioDAO;
import modelo.Usuario;

public class ConsultaUsuario extends JInternalFrame implements ActionListener{

	JTextField cajaNombre,cajaPrimerAp,cajaSegundoAp,cajaCorreo,cajaId;
	JButton btnCancelar,btnLimpiar,btnBuscar;
	
	//ImageIcon iconoRescribir=new ImageIcon("./recursos/Rescribir.png");
	ImageIcon iconoRegresar=new ImageIcon("./recursos/Regresar.png");
	ImageIcon iconoBorrar=new ImageIcon("./recursos/Restablecer.png");
	ImageIcon iconoBuscar=new ImageIcon("./recursos/lupa.png");
	
	public static byte bandera;
	
	JTable tabla=new JTable();
	public ConsultaUsuario() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(325, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(48, 158, 125));
		setTitle("Consultas");
		
		//setIconifiable(true);//Minimizar
		setResizable(false);//Cambiar tamaño
		//setClosable(true);//Cerrar
		
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
		
		actualizarTabla();
		JScrollPane scroll=new JScrollPane(tabla);
		scroll.setBounds(0, 270, 300, 80);add(scroll);
		
		setResizable(true);
		
		//Iconos botones
		btnLimpiar=new JButton(iconoBorrar);
		btnLimpiar.setIcon(new ImageIcon(iconoBorrar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnLimpiar.setBounds(1, 200,50, 60);add(btnLimpiar);
		
		
		
		btnCancelar=new JButton(iconoRegresar);
		btnCancelar.setIcon(new ImageIcon(iconoRegresar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnCancelar.setBounds(180, 200,50, 60);add(btnCancelar);
		
		//Eventos
		
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
				}
			}
			@Override public void keyPressed(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
		});
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			UsuarioDAO uDAO=new UsuarioDAO();
			if(!cajaId.getText().isEmpty()) {
			uDAO.setFiltro(Integer.parseInt(cajaId.getText()));
			Thread hilo=new Thread(uDAO);
			hilo.start();
			Usuario usu= uDAO.buscar(Integer.parseInt(cajaId.getText()));
			if(bandera==1 && usu!=null) {
				System.out.println(bandera);
				//bandera=0;
				//System.out.println(usu);
				cajaCorreo.setText(usu.getCorreo());
				cajaNombre.setText(usu.getNombre());
				cajaPrimerAp.setText(usu.getPrimerAp());
				cajaSegundoAp.setText(usu.getSegundoAp());
				uDAO.setFiltro(0);
				
				}
			}else {
				JOptionPane.showMessageDialog(null,"La casilla ID no puede estar vacia.");
			}
			
		}else if(e.getSource()==btnLimpiar) {
			restablecer(cajaCorreo,cajaId,cajaNombre,cajaPrimerAp,cajaSegundoAp);
		}else if(e.getSource()==btnCancelar) {
			setVisible(false);
		}
		
	}
	public void actualizarTabla() {
		
		String controlador = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/libreria";
		String consulta = "SELECT * FROM usuario_cliente";
		
		ResultSetTableModel modeloDatos=null;
		try {
			modeloDatos = new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tabla.setModel(modeloDatos);
		
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
