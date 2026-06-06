package Logica;
import java.util.ArrayList;
import java.util.List;

import Dominio.*;

public class SistemaImplementado implements Sistema {
	private static List<Hechizo> hechizos = new ArrayList<>();
	@Override
	public void crearHechizo(String linea) {
		String[] partes = linea.split(";");
		//crea dependiendo del tipo
		if(partes[1].equals("Agua")) {
			String[] parteEspecifica = partes[3].split(","); //para la parte final que se dibide en 2 
			hechizos.add(new Agua(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(parteEspecifica[0]), Integer.parseInt(parteEspecifica[1])));
		}
		if(partes[1].equals("Fuego")) {
			hechizos.add(new Fuego(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3])));
		}
		if(partes[1].equals("Planta")) {
			String[] parteEspecifica = partes[3].split(","); //lo mismo que agua 
			hechizos.add(new Planta(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(parteEspecifica[0]), Integer.parseInt(parteEspecifica[1])));
		}
		if(partes[1].equals("Tierra")) {
			hechizos.add(new Tierra(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3])));
		}
		System.out.println(partes[1]+":"+hechizos.getLast()+"|tamanio: "+hechizos.size()); //test 
	}

}
