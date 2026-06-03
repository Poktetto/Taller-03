package Dominio;

public class Tierra extends Hechizo {
	private int mejoraDefensa;

	public Tierra(String nombre, String tipo, int danio,int mejoraDefensa) {
		super(nombre, tipo, danio);
		this.mejoraDefensa=mejoraDefensa;
	}

}
