package vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaBajasUsuarios extends JInternalFrame {
	
	JTextField cajaNombre,cajaPrimerAp,cajaSegundoAp,cajaCorreo,cajaId;
	JButton btnBaja,btnCancelar,btnBorrar,btnBuscar;
	
	ImageIcon iconoBaja=new ImageIcon("./recursos/216658.png");
	ImageIcon iconoRegresar=new ImageIcon("./recursos/Regresar.png");
	ImageIcon iconoBorrar=new ImageIcon("./recursos/Restablecer.png");
	ImageIcon iconoBuscar=new ImageIcon("./recursos/lupa.png");
	
	public VentanaBajasUsuarios() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(270, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(147, 192, 244));
		setTitle("Eliminar Usuario");
		
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
		btnBaja=new JButton(iconoBaja);
		btnBaja.setIcon(new ImageIcon(iconoBaja.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnBaja.setBounds(1, 200,50, 60);add(btnBaja);
		
		btnBorrar=new JButton(iconoBorrar);
		btnBorrar.setIcon(new ImageIcon(iconoBorrar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnBorrar.setBounds(90, 200,50, 60);add(btnBorrar);
		
		btnCancelar=new JButton(iconoRegresar);
		btnCancelar.setIcon(new ImageIcon(iconoRegresar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnCancelar.setBounds(180, 200,50, 60);add(btnCancelar);
		
	}
}