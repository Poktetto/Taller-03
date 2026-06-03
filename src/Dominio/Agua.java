package Dominio;

public class Agua extends Hechizo {
	private int cantidadHeal;
	private int presionDelAgua;
	

	public Agua(String nombre, String tipo, int danio, int cantidadHeal, int presionDelAgua) {
		super(nombre, tipo, danio);
		this.cantidadHeal=cantidadHeal;
		this.presionDelAgua=presionDelAgua;
	}

}
