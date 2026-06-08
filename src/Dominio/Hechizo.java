package Dominio;

public class Hechizo {
	private String nombre;
	private String tipo ;
	private int danio;
	
	public Hechizo(String nombre, String tipo, int danio) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.danio = danio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	
	


}
