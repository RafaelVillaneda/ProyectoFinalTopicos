package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConexionBD.ConexionBD;
import modelo.Libro;
import modelo.Usuario;
import modelo.UsuarioAdministrador;
import vista.ConsultaUsuario;

public class UsuarioDAO implements Runnable{
	private int filtro;
	public boolean insertarRegistro(Usuario a) {
		boolean resultado=false;
	
		resultado=ConexionBD.AgregarRegistroTablaUsuarios(a);
		
		return resultado;	
	}
	public boolean eliminarRegistro(String idEliminar) {

		String instruccion="DELETE FROM usuario_cliente WHERE id_usuario = '"+idEliminar+"';";
        boolean resultado = false;
		resultado = ConexionBD.EliminarRegistro(instruccion);
		
		return resultado;
	}//Modificar
	public boolean modificarUsuario(Usuario a) {
		boolean resultado = false;
		String sql="UPDATE usuario_cliente SET nombre=? where id_usuario="+a.getId()+"";
		resultado=ConexionBD.ActualizarRegistroUsuario(a);
		
		return resultado;
	}
	public Usuario buscar(int filtro){
		Usuario u1=new Usuario();
		String sql="SELECT * FROM usuario_cliente WHERE id_usuario ='"+filtro+"';";
		
		ResultSet rs=ConexionBD.ConsultarRegistro(sql);
		
		try {
			
			if(rs.next()) {

			u1.setId(rs.getInt(1));
			u1.setNombre(rs.getString(2));
			u1.setPrimerAp(rs.getString(3));
			u1.setSegundoAp(rs.getString(4));
			u1.setCorreo(rs.getString(5));
			ConsultaUsuario.bandera=1;
			}else {
				JOptionPane.showMessageDialog(null,"No existe el usuario");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u1;
	}
	@Override
	public void run() {
		buscar(this.filtro);
		
	}
	public int getFiltro() {
		return filtro;
	}
	public void setFiltro(int filtro) {
		this.filtro = filtro;
	}
	
	
}
