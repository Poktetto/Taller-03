package Dominio;

public class Planta extends Hechizo {
	private int duracionStun;
	private int cantPlantas;
	

	public Planta(String nombre, String tipo, int danio, int duracionStun, int cantPlantas) {
		super(nombre, tipo, danio);
		this.duracionStun=duracionStun;
		this.cantPlantas=cantPlantas;
		puntaje=danio+(duracionStun*cantPlantas);
	}
	


}
