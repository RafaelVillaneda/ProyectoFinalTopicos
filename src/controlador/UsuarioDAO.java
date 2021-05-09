package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexionBD.ConexionBD;
import modelo.Libro;
import modelo.Usuario;
import modelo.UsuarioAdministrador;

public class UsuarioDAO {

	public boolean insertarRegistro(Usuario a) {
		boolean resultado=false;
	
		resultado=ConexionBD.AgregarRegistroTablaUsuarios(a);
		
		return resultado;	
	}
	public boolean eliminarRegistro(String sql) {
		
		// DELETE FROM libros WHERE id_libro = 'filtrio';
		
        boolean resultado = false;
		resultado = ConexionBD.EliminarRegistro(sql);
		
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
			
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u1;
	}
	
}
