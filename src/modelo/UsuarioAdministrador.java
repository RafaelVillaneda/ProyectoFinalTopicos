package modelo;

public class UsuarioAdministrador extends Usuario{

	private String contraseña;

	public UsuarioAdministrador(int id, String nombre, String primerAp, String segundoAp, String correo,
			String contraseña) {
		super(id, nombre, primerAp, segundoAp, correo);
		this.contraseña = contraseña;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
