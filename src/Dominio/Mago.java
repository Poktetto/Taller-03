package Dominio;
import java.util.List;
import java.util.ArrayList;

public class Mago {
	private String nombre;
	private static List<String> hechizos= new ArrayList<>();
	public Mago(String nombre, String linea) {
		this.nombre = nombre;
		String[] partes = linea.split("\\|"); //para separar los hechizos 
		for (int i =0; i<partes.length;i++) {
			hechizos.add(partes[i]);
		}
	} 
	
}
