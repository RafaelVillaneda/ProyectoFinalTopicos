package controlador;

import ConexionBD.ConexionBD;
import modelo.Movimiento;

public class MovimientoDAO {
	
	public boolean insertarRegistro(Movimiento m) {
		boolean resultado=false;
	
		resultado=ConexionBD.AgregarRegistroTablaMovimientos(m);
		
		return resultado;	
	}
}
