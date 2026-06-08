package Dominio;

public class Hechizo {
	private String nombre;
	private String tipo ;
	protected int danio;
	protected double puntaje;
	
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
	public double getPuntaje() {
		return puntaje;
	}
	
	
	


}
