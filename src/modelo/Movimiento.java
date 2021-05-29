package modelo;

public class Movimiento {
	
	private int id_Movimiento,id_libro,id_usuario;
	private String fecha;
	
	public Movimiento() {}
	
	public Movimiento(int id_Movimiento, int id_libro, int id_usuario, String fecha) {
		this.id_Movimiento = id_Movimiento;
		this.id_libro = id_libro;
		this.id_usuario = id_usuario;
		this.fecha = fecha;
	}

	public int getId_Movimiento() {
		return id_Movimiento;
	}

	public void setId_Movimiento(int id_Movimiento) {
		this.id_Movimiento = id_Movimiento;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
