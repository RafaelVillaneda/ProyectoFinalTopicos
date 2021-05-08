package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexionBD.ConexionBD;
import modelo.UsuarioAdministrador;

public class UsuarioAdministradorDAO {

	
	
	public ArrayList<UsuarioAdministrador> buscar(String filtro){
		
		ArrayList<UsuarioAdministrador> listaAlumnos=new ArrayList<>();
		String sql="SELECT * FROM usuario_bibliotecario WHERE id_usuario ='"+filtro+"';";
		
		ResultSet rs=ConexionBD.ConsultarRegistro(sql);
		
		try {
			if(rs.next()) {
				do {
					
					listaAlumnos.add(new UsuarioAdministrador(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), filtro,rs.getString(5)));
				}while(rs.next());
				
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaAlumnos;
	}
	
	
	
}
