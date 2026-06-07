package Logica;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
	private static Sistema sistema =new SistemaImplementado();
	public static void main(String[] args) throws IOException {
		cargarHechizos();  
		cargarMagos();
		menuInicial();
	}

	private static void menuInicial() throws IOException {
		Scanner s = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("1)Administrador");
		System.out.println("2)Analista");
		System.out.println("3)Salir");
		System.out.println("--------------------------------");
		String respuesta = " ";
		do {
			System.out.print(">");
			respuesta = s.nextLine();
		} while(Integer.parseInt(respuesta)<1 || Integer.parseInt(respuesta)>3);
		//opciones
		if (respuesta.equals("1")) {
			menuAdmin();
		} 
		if (respuesta.equals("2"))
			menuAnalista();
		} 
					

	private static void menuAnalista() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("--------------------------------");
		System.out.println("1)Top 10 Mejores Hechizos");
		System.out.println("2)Top 3 Mejores Magos");
		System.out.println("3)Mostrar todos los Hechizos");
		System.out.println("4)Mostrar todos los magos");
		System.out.println("5)Mostrar todos los Hechizos junto a su puntuacion");
		System.out.println("6)Mostrar todos los magos junto a su puntuacion");
		System.out.println("7)Salir");
		System.out.println("--------------------------------");
		int respuesta=0;
		do {
			System.out.print(">");
			String opcionString = s.nextLine();
			respuesta= Integer.parseInt(opcionString);
		} while(respuesta<1 || respuesta>7);
		
		switch (respuesta) {
		case 1: //mostrar Top 10
			break;
		case 2://op mostrar Top 3
			break;
		case 3://mostrar hechizos
			for (int i=0; i<sistema.cantidadHechizos();i++) {
				System.out.println(i+1+") " + sistema.mostrarHechizos(i)); 
			}break;
		case 4://op mostrar magos
			for (int i=0; i<sistema.cantidadMagos();i++) {
				System.out.println(sistema.mostrarMagos(i));//imprime los magos con sus hechizos
			}
			
		
		
		}
			
	}

	private static void menuAdmin() throws IOException {
		Scanner s = new Scanner(System.in);
		
		System.out.println("--------------------------------");
		System.out.println("1)Agregar Mago");
		System.out.println("2)Modificar Mago");
		System.out.println("3)Eliminar Mago");
		System.out.println("4)Agregar Hechizo");
		System.out.println("5)Modificar Hechizo");
		System.out.println("6)Eliminar Hechizo");
		System.out.println("7)Salir");
		System.out.println("--------------------------------");
		String respuesta = " ";
		do {
			System.out.print(">");
			respuesta = s.nextLine();
		} while(Integer.parseInt(respuesta)<1 || Integer.parseInt(respuesta)>7);
		//opciones 
		if (respuesta.equals("1")) {
			System.out.println("--------------------------------");
			System.out.println("Indique nombre del nuevo mago");
			System.out.print(">");
			String nombreMago = s.nextLine();
			System.out.println("--------------------------------");
			//print lista de hechizos 
			for (int i=0; i<sistema.cantidadHechizos();i++) {
				System.out.println(i+1+") " + sistema.mostrarHechizos(i)); 
			}
			System.out.println("--------------------------------");
			System.out.println("Cual hechizo desea añadir? (0 para terminar)");
			String aniadirHechizo = "-1"; //ciclo aniadicion de hechizos
			String lineaHechizos=null;//creado para "almacenar" los hechizos
			do {
				aniadirHechizo=s.nextLine();
				//el codigo se trabajo bajo el supuesto que un mago debe tener hechizos, y para que sea claro se coloca el print en caso que pase
				if(Integer.parseInt(aniadirHechizo)==0 && lineaHechizos==null ) {
					System.out.println("un mago debe tener hechizos");
					continue;
				}
				if(Integer.parseInt(aniadirHechizo)>0 && Integer.parseInt(aniadirHechizo)<=sistema.cantidadHechizos()){
					lineaHechizos=sistema.unionHechizosMagos(aniadirHechizo,lineaHechizos);
				}
				
				if(Integer.parseInt(aniadirHechizo)!=0) {
					System.out.println("se ha añadido " + sistema.mostrarHechizos(Integer.parseInt(aniadirHechizo)-1));
				}
			} while (Integer.parseInt(aniadirHechizo)>0 || Integer.parseInt(aniadirHechizo)>sistema.cantidadHechizos() || lineaHechizos==null);
			sistema.agregarMago(nombreMago, lineaHechizos, actualizarMagos());
			cargarMagos(); //para la lista en sistema
		}
		else if (respuesta.equals("2")) { //opcion de modificar 
			System.out.println("--------------------------------");
			System.out.println("Magos disponibles");
			for (int i=0; i<sistema.cantidadMagos();i++) {
				System.out.println(sistema.mostrarMagos(i));//imprime los magos con sus hechizos
			}
			System.out.println("Indique el numero del mago a modificar");
			System.out.print(">");
			String magoNumero = s.nextLine();
			int numeroMago=Integer.parseInt(magoNumero);
			System.out.println("--------------------------------");
			System.out.println("¿Que desea modificar?");
			System.out.println("1) Agregar hechizo");
			System.out.println("2) Eliminar hechizo");
			//habra que crear uno para cambiar nombre?
			System.out.print(">");
			String opString= s.nextLine();
			//falta realizar try catch
			int opcion=Integer.parseInt(opString);
			if (opcion==1) {
				for (int i=0; i<sistema.cantidadHechizos();i++) {
					System.out.println(i+1+") " + sistema.mostrarHechizos(i)); 
				}
				System.out.println("--------------------------------");
				System.out.println("Cual hechizo desea añadir? ");
				String aniadirHechizo =s.nextLine();
				int numeroHechizo=	Integer.parseInt(aniadirHechizo);				//ciclo aniadicion de hechizos
				sistema.agregarHechizo(numeroMago,aniadirHechizo); //falta arreglar, rompe las reglas, no lo hago ahora pq son las 5am :v
				
				if(Integer.parseInt(aniadirHechizo)!=0) {
					System.out.println("se ha añadido " + sistema.mostrarHechizos(Integer.parseInt(aniadirHechizo)-1));
				}
				
			}
			
			
			
		}
		
		
	}

	private static String actualizarMagos() throws IOException { //guarda todo el txt en una linea separada por ";"
		File arc =new File("txts/Magos.txt");
		Scanner sArc = new Scanner(arc);
		String archivo= "No";
		while (sArc.hasNextLine()) {
			String linea= sArc.nextLine();
			if (archivo.equals("No")){
				archivo = linea;
			} else {
				archivo +="🐟"+linea;//?¿
			}
			
		}
		return archivo;
	}

	private static void cargarMagos() throws IOException {
		File arc =new File("txts/Magos.txt");
		Scanner sArc = new Scanner(arc);
		while (sArc.hasNextLine()) {
			String linea= sArc.nextLine();
			sistema.crearMago(linea);
		}
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
