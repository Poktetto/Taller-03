package Dominio;

public class Fuego extends Hechizo {
	private int duracionQuemadura;
	

	public Fuego(String nombre, String tipo, int danio, int duracionQuemadura ) {
		super(nombre, tipo, danio);
		this.duracionQuemadura=duracionQuemadura;
		puntaje=danio*duracionQuemadura;
	}



}
