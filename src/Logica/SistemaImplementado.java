package Logica;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Dominio.*;

public class SistemaImplementado implements Sistema {
	private static List<Hechizo> hechizos = new ArrayList<>();
	private static List<Mago> magos = new ArrayList<>();
	
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
	}
	@Override
	public void crearMago(String linea) {
		String[] partes = linea.split(";");
		magos.add(new Mago(partes[0],partes[1]));
		
	}
	public String mostrarMagos(int i) {
		return i+") "+ magos.get(i).toString();
	}
	public int cantidadMagos() {
		return magos.size();
	}

	@Override
	public String mostrarHechizos(int i) {
			return hechizos.get(i).getNombre();
		}
	@Override
	public int cantidadHechizos() {
		return hechizos.size();
		
	}
	public int cantidadHechizos(int mago) {
		return magos.get(mago).tamanioHechizosM();
		
	}
	@Override
	public String unionHechizosMagos(String aniadirHechizo, String lineaHechizos) {
		if (lineaHechizos==null) {
			lineaHechizos = mostrarHechizos(Integer.parseInt(aniadirHechizo)-1);
			return lineaHechizos;
		} else {
			lineaHechizos += "|" + mostrarHechizos(Integer.parseInt(aniadirHechizo)-1);
			return lineaHechizos;
		}
		
	}
	@Override
	public void agregarMago(String nombreMago, String lineaHechizos, String linea) throws IOException {
		int cantMagos = magos.size();
		magos.clear();
		FileWriter writerRegistro = new FileWriter("txts/Magos.txt"); // se resetea el achivo 
		BufferedWriter escritor =new BufferedWriter(writerRegistro); //y se procede a recrear
		escritor.write(nombreMago+";"+lineaHechizos);
		escritor.close();
		String[] partes =linea.split("🐟"); //??¿¿
		for (int i=0; i<cantMagos;i++) {
			recargarTxtMagos(partes[i]);
		}
		
		
	}
	private void recargarTxtMagos(String linea) throws IOException {
		FileWriter writerRegistro = new FileWriter("txts/Magos.txt",true); // se resetea el achivo 
		BufferedWriter escritor =new BufferedWriter(writerRegistro); //y se procede a recrear
		escritor.newLine();
		escritor.write(linea);
		escritor.close();
		
	}
	
	public void agregarHechizo(int mago,int hechizo) {
		
		magos.get(mago).getHechizosM().add(hechizos.get(hechizo).getNombre());
		
	}


}
