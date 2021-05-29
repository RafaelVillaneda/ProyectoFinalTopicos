package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import ConexionBD.ConexionBD;
import modelo.Libro;
import modelo.Movimiento;
import vista.VentanaEliminarLibro;

public class MovimientoDAO {
	
	public boolean insertarRegistro(Movimiento m) {
		boolean resultado=false;
	
		resultado=ConexionBD.AgregarRegistroTablaMovimientos(m);
		
		return resultado;	
	}
	
	public boolean eliminarRegistro(String idEliminar) {

		String instruccion="DELETE FROM movimientos WHERE id_movimiento = "+Integer.parseInt(idEliminar)+";";
        boolean resultado = false;
		resultado = ConexionBD.EliminarRegistro(instruccion);
		
		return resultado;
		
	}//Modificar
	public boolean eliminarRegistroPorLibro(String idEliminar) {

		String instruccion="DELETE FROM movimientos WHERE id_libro = '"+idEliminar+"';";
        boolean resultado = false;
		resultado = ConexionBD.EliminarRegistro(instruccion);
		
		return resultado;
	}//Modificar
	public Movimiento buscar(int filtro){
		Movimiento mov=new Movimiento();
		String sql="SELECT * FROM movimientos WHERE id_movimiento ="+filtro+";";
		
		ResultSet rs=ConexionBD.ConsultarRegistro(sql);
		
		try {
			
			if(rs.next()) {
				mov.setId_libro(rs.getInt(2));
				mov.setId_usuario(rs.getInt(3));
				mov.setFecha(rs.getString(4));
			}else {
				VentanaEliminarLibro.bandera=0;
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}//0==no 1==si
		VentanaEliminarLibro.bandera=1;
		return mov;
	}
	
	
}
