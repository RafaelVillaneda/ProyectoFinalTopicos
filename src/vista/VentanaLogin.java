package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaLogin extends JFrame implements ActionListener{
	
	ImageIcon iconoUsuario=new ImageIcon("./recursos/usuario.png");
	
	JLabel lbl1 = new JLabel(iconoUsuario);
	
	private JTextField txtIdUsuario=new JTextField(10);
	private JTextField txtContraseña=new JTextField(10);
	
	JButton btnIngresar=new JButton();
	
	
	public VentanaLogin() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
		setTitle("Iniciar Secion");
		
		lbl1.setBounds(100,0,100,100);
		lbl1.setIcon(iconoUsuario);
		add(lbl1);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
