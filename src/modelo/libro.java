package modelo;

public class Libro {

	private String nombre;
	private String genero;
	private String autor;
	private String editorial;
	private int IDLibro;
	public Libro() {}
	public Libro(String nombre, String genero, String autor, String editorial,int IDlibro) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.autor = autor;
		this.editorial = editorial;
		this.IDLibro=IDlibro;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getIDLibro() {
		return IDLibro;
	}

	public void setIDLibro(int iDLibro) {
		IDLibro = iDLibro;
	}
	
	
	
}
