package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaLogin extends JFrame implements ActionListener{
	
	ImageIcon iconoUsuario=new ImageIcon("./recursos/usuario.png");
	
	JLabel lbl1 = new JLabel();
	
	private JTextField txtIdUsuario=new JTextField(10);
	private JTextField txtContraseña=new JTextField(10);
	
	JButton btnIngresar=new JButton("Ingresar");
	
	
	public VentanaLogin() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
		this.getContentPane().setBackground(new Color(147, 192, 244));
		setTitle("Iniciar Secion");
		
		//Icono
		lbl1.setBounds(100,0,100,100);
		lbl1.setIcon(new ImageIcon(iconoUsuario.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		add(lbl1);
		
		JLabel lb2=new JLabel("ID. usuario");
		lb2.setBounds(120, 110, 100, 25);
		add(lb2);
		
		txtIdUsuario.setBounds(80, 130, 150, 20);
		add(txtIdUsuario);
		
		JLabel lb3=new JLabel("Contraeña");
		lb3.setBounds(120, 150, 76, 25);
		add(lb3);
		
		txtContraseña.setBounds(80, 175, 150, 20);
		add(txtContraseña);
		
		btnIngresar.setBounds(80, 215, 150, 30);
		add(btnIngresar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
