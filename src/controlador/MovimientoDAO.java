package controlador;

import ConexionBD.ConexionBD;
import modelo.Movimiento;

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
	
	
}
