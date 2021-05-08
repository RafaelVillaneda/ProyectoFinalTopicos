package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VentanaMostrarMovimientos extends JInternalFrame{

	JTable tablaMovimientos=new JTable(4,4);
	JButton btnSalir;
	ImageIcon iconoRegresar=new ImageIcon("./recursos/Regresar.png");
	
	public VentanaMostrarMovimientos() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 250);
		setVisible(true);
		this.getContentPane().setBackground(new Color(48, 158, 125));
		setTitle("Mostrar movimientos");
		
		actualizarTabla();
		JScrollPane scroll=new JScrollPane(tablaMovimientos);
		scroll.setBounds(15,0,250,100);add(scroll);
		
		btnSalir=new JButton(iconoRegresar);
		btnSalir.setIcon(new ImageIcon(iconoRegresar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnSalir.setBounds(115, 115, 50, 50);add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	}
	public void actualizarTabla() {
		
		String controlador = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/libreria";
		String consulta = "SELECT * FROM movimientos";
		
		ResultSetTableModel modeloDatos=null;
		try {
			modeloDatos = new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		tablaMovimientos.setModel(modeloDatos);
		//scroll.setPreferredSize( 400, 600 );
		
	}
	
}
