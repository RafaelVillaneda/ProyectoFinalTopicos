package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ConexionBD.ConexionBD;
import modelo.Libro;
import modelo.Usuario;
import vista.VentanaConsultasLibros;
import vista.VentanaEliminarLibro;

public class LibroDAO implements Runnable{
	
	private int filtro;
	
	
	
	public boolean insertarRegistro(Libro a){
		boolean resultado=false;
	
		resultado=ConexionBD.AgregarRegistroTablaLibros(a);
		
		return resultado;	
	}
	public boolean modificarLibro(Libro a) {
		boolean resultado = false;
		String sql = "UPDATE libros SET nombre='"+a.getNombre()+"', genero='"+a.getGenero()+"', autor='"+a.getAutor()+"',"
				+ "              editorial = '"+a.getEditorial()+"';";
		
		sql="UPDATE libros SET nombre=? where id_libro="+a.getIDLibro()+"";
		ConexionBD.ActualizarRegistro(a);
		
		return false;
	}
	public Libro buscar(int filtro){
		Libro l1=new Libro();
		String sql="SELECT * FROM libros WHERE id_libro ="+filtro+";";
		
		ResultSet rs=ConexionBD.ConsultarRegistro(sql);
		
		try {
			
			if(rs.next()) {
				l1.setIDLibro(rs.getInt(1));
				l1.setNombre(rs.getString(2));
				l1.setGenero(rs.getString(3));
				l1.setAutor(rs.getString(4));
				l1.setEditorial(rs.getString(5));
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}//0==no 1==si
		VentanaEliminarLibro.bandera=1;
		return l1;
	}
	public boolean eliminarRegistro(String idEliminar) {

		String instruccion="DELETE FROM libros WHERE id_libro = '"+idEliminar+"';";
        boolean resultado = false;
		resultado = ConexionBD.EliminarRegistro(instruccion);
		
		return resultado;
	}//Modificar
	
	@Override
	public void run() {
		buscar(this.filtro);
		
	}
	public void setFiltro(int filtro) {
		this.filtro = filtro;
	}
	
	
	
}
