package Dominio;
import java.util.List;
import java.util.ArrayList;

public class Mago {
	private String nombre;
	private List<String> hechizosM= new ArrayList<>();
	public Mago(String nombre, String linea) {
		this.nombre = nombre;
		String[] partes = linea.split("\\|"); //para separar los hechizos 
		for (int i =0; i<partes.length;i++) {
			
			hechizosM.add(partes[i]);
		}
	}
	@Override
	public String toString() {
		return nombre+"| hechizos: "+ hechizosM;
	}
	public int tamanioHechizosM() {
		return hechizosM.size();
	}
	public List<String> getHechizosM() {
		return hechizosM;
	}

	public void agregarHechizo(String hechizo) {
		this.hechizosM.add(hechizo);
	}
	
	
	
	
}
