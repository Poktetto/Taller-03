package Logica;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
	private static Sistema sistema =new SistemaImplementado();
	public static void main(String[] args) throws IOException {
		cargarHechizos();  //print test despues de cargarlo 
		
	}

	private static void cargarHechizos() throws IOException {
		File arc =new File("txts/Hechizos.txt");
		Scanner sArc = new Scanner(arc);
		while (sArc.hasNextLine()) {
			String linea= sArc.nextLine();
			sistema.crearHechizo(linea);
			
		}
	}

}
