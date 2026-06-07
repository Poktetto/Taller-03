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
		int cantMagos = magos.size(); //almacena la cantidad de magos 
		magos.clear(); // reinicia magos como es static 
		FileWriter writerRegistro = new FileWriter("txts/Magos.txt"); // se resetea el achivo 
		BufferedWriter escritor =new BufferedWriter(writerRegistro); //y se procede a recrear
		escritor.write(nombreMago+";"+lineaHechizos); //escribe el mago ingresado 
		escritor.close(); //cierra es escritor para que se guarde 
		String[] partes =linea.split("🐟"); //??¿¿ //separa las el txt (completo separado por "🐟") en diferentes partes
		for (int i=0; i<cantMagos;i++) { //ciclo por el total antiguo de magos 
			recargarTxtMagos(partes[i]); //añade mago por magos 
		} // y así hasta que termina de escribir todos 
		
		
	}
	private void recargarTxtMagos(String linea) throws IOException {
		FileWriter writerRegistro = new FileWriter("txts/Magos.txt",true); //escibe más elementos
		BufferedWriter escritor =new BufferedWriter(writerRegistro); 
		escritor.newLine(); //salta de linea
		escritor.write(linea); //rescribe la linea que probiende de la funcion de los "🐟"
		escritor.close(); //cierra para guardar
		
	}
	
	public void agregarHechizo(int mago,int hechizo) {
		
		magos.get(mago).getHechizosM().add(hechizos.get(hechizo).getNombre());
		
	}


}
