package Logica;
//Alvaro Sebastian Orrego Ramírez RUT:22185824-7  Carrera: ITI
//Anita Constanza Rojas Urrutia RUT: 22286335-K  Carrera: ITI

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
	
			for (int i=0;i<sistema.cantidadHechizos();i++) {
				sistema.calcularPuntajeI(i);
			}
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
		String respuesta = " ";
		do {
		System.out.println("--------------------------------");
		System.out.println("1)Agregar Mago");
		System.out.println("2)Modificar Mago");
		System.out.println("3)Eliminar Mago");
		System.out.println("4)Agregar Hechizo");
		System.out.println("5)Modificar Hechizo");
		System.out.println("6)Eliminar Hechizo");
		System.out.println("7)Salir");
		System.out.println("--------------------------------");
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
				//toda esta parte "fea" es puro control de errores 
			} while (Integer.parseInt(aniadirHechizo)>0 || Integer.parseInt(aniadirHechizo)>sistema.cantidadHechizos() || lineaHechizos==null);
			sistema.agregarMago(nombreMago, lineaHechizos, actualizarMagos()); //actualizar magos es todo el txt junto en forma de "🐟" esto solo se hace una vez
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
			int numeroMago=Integer.parseInt(magoNumero)-1;
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
				System.out.print(">");
				String aniadirHechizo =s.nextLine();
				
				 
				
				int numeroHechizo=	Integer.parseInt(aniadirHechizo)-1;				//ciclo aniadicion de hechizos
				sistema.agregarHechizo(numeroMago,numeroHechizo);
				 String linea = actualizarMagos();
				  
				  String nombreNuevoHechizo = sistema.mostrarHechizos(numeroHechizo);
				  
				  sistema.modificarMago(numeroMago, nombreNuevoHechizo, linea);
				  
				  cargarMagos();
				  
				  
				if(Integer.parseInt(aniadirHechizo)!=0) {
					System.out.println("se ha añadido " + sistema.mostrarHechizos(numeroHechizo));
				}
				
			}else if (opcion==2) { //opcion eliminar 
				for (int i=0; i<sistema.cantidadHechizos(numeroMago);i++) {
					
					System.out.println(sistema.mostrarMagosHechizo( i,  numeroMago));
					
				}
				System.out.println("--------------------------------");
				System.out.println("Cual hechizo desea eliminar? ");
				System.out.print(">");
				String eliminaHechizo =s.nextLine();
				int numeroHechizo=	Integer.parseInt(eliminaHechizo)-1;
				sistema.eliminarHechizo(numeroMago,numeroHechizo); //elimina el hechizo de la lista
				
				String linea = actualizarMagos();
				  
				 
				  
				  sistema.modificarMago(numeroMago,numeroHechizo, linea);
				  
				  cargarMagos();
				  System.out.print("Hechizo eliminado");
			}
			
			
			
		}
		else if (respuesta.equals("3")){
			System.out.println("--------------------------------");
			//imprimir todos los magos
			for (int i=0;i<sistema.cantidadMagos();i++) {
				System.out.println(sistema.mostrarMagos(i));
			}
			System.out.println("--------------------------------");
			System.out.println("cual mago desea eliminar?");
			System.out.print(">");
			String indiceMago= "-1";
			do {
				indiceMago = s.nextLine();
			} while(Integer.parseInt(indiceMago)-1<0|| Integer.parseInt(indiceMago)-1>=sistema.cantidadMagos());
			sistema.eliminarMago(Integer.parseInt(indiceMago)-1, actualizarMagos());
			cargarMagos();
		}
		else if (respuesta.equals("4")) {
			System.out.println("--------------------------------");
			System.out.println("cual es el nombre del nuevo hechizo?");
			System.out.print(">");
			String nombreHechizo= s.nextLine();
			System.out.println("--------------------------------");
			System.out.println("de que tipo es?");
			System.out.println("1)Fuego");
			System.out.println("2)Tierra");
			System.out.println("3)Panta");
			System.out.println("4)Agua");
			System.out.println("--------------------------------");
			String tipoHechizo ="0";
			do {
				System.out.print(">");
				tipoHechizo = s.nextLine();
			} while (Integer.parseInt(tipoHechizo)<1||Integer.parseInt(tipoHechizo)>4);
			System.out.println("ingrese daño");
			int danio = darDatoHechizos();
			String tipo="";
			String parte4=""; //para unir las partes para planta y agua
			if (tipoHechizo.equals("1")) { //si es fuego
				System.out.println("Ingrese duracion de quemadura");
				int duracionQuemadura= darDatoHechizos();
				parte4 =""+duracionQuemadura;
				tipo="Fuego";
			} 
			else if (tipoHechizo.equals("2")) { //si es Tierra
				System.out.println("Ingrese mejora de defenza");
				int mejoraDefenza= darDatoHechizos();
				parte4 = ""+mejoraDefenza;
				tipo="Tierra";
			}
			else if (tipoHechizo.equals("3")) { //si es Planta
				System.out.println("Ingrese duracion del stun");
				int duracionStun= darDatoHechizos();
				System.out.println("Ingrese cantidad de plantas");
				int cantidadPlantas = darDatoHechizos();
				parte4= duracionStun+","+cantidadPlantas;
				tipo="Planta";
			}
			else if (tipoHechizo.equals("4")) { //si es Agua
				System.out.println("Ingrese cantidad de Heal");
				int cantidadHeal= darDatoHechizos();
				System.out.println("Ingrese presion del agua");
				int presionAgua = darDatoHechizos();
				parte4= cantidadHeal+","+presionAgua;
				tipo="Agua";
			}
			String hechizoNuevo= nombreHechizo+";"+tipo+";"+danio+";"+parte4;
			sistema.agregarHechizoTxt(hechizoNuevo,actualizarHechizos());
			cargarHechizos();
			
		}
		else if (respuesta.equals("5")) {
			System.out.println("--------------------------------");
			System.out.println("hechizos disponibles");
			for(int i=0;i<sistema.cantidadHechizos();i++) {
				System.out.println(i+1+")"+sistema.mostrarHechizos(i));
			}
			System.out.println("--------------------------------");
			System.out.println("cual desea modificar?");
			int indiceHechizo=0;
			do {
				System.out.print(">");
				indiceHechizo = Integer.parseInt(s.nextLine())-1;
			}while (indiceHechizo<0||indiceHechizo>sistema.cantidadHechizos());
			System.out.println("--------------------------------");
			System.out.println("1)Modificar nombre");
			System.out.println("2)Modificar daño");
			System.out.println("3)Modificar tipo");
			int cosaCambiar=0;
			if (sistema.mostrarTipoHechizo(indiceHechizo).equals("Fuego")) {
				System.out.println("4)Modificar duracion de quemadura");
				do {
					System.out.print(">");
					cosaCambiar = Integer.parseInt(s.nextLine())-1;
				}while (cosaCambiar<0||cosaCambiar>4);
			}
			else if (sistema.mostrarTipoHechizo(indiceHechizo).equals("Tierra")) {
				System.out.println("4)Modificar mejora de defenza");
				do {
					System.out.print(">");
					cosaCambiar = Integer.parseInt(s.nextLine())-1;
				}while (cosaCambiar<0||cosaCambiar>4);
			}
			else if (sistema.mostrarTipoHechizo(indiceHechizo).equals("Planta")) {
				System.out.println("4)Modificar duracion del Stun");
				System.out.println("5)Modificar cantidad de plantas");
				do {
					System.out.print(">");
					cosaCambiar = Integer.parseInt(s.nextLine())-1;
				}while (cosaCambiar<0||cosaCambiar>5);
			}
			else if (sistema.mostrarTipoHechizo(indiceHechizo).equals("Agua")) {
				System.out.println("4)Modificar cantidad de Healing");
				System.out.println("5)Modificar presion del agua");
				do {
					System.out.print(">");
					cosaCambiar = Integer.parseInt(s.nextLine())-1;
				}while (cosaCambiar<0||cosaCambiar>5);
			}
			//cargar opciones dependiendo del cambio
			if (cosaCambiar+1==1) { //cambiar nombre
				String antiguoNombre=sistema.mostrarHechizos(indiceHechizo);
				System.out.println("--------------------------------");
				System.out.println("Ingrese nuevo Nombre");
				String nuevoNombre=s.nextLine();
				sistema.modificarHechizo(1, nuevoNombre, actualizarHechizos(), antiguoNombre);
				cargarHechizos();
				sistema.actualizarHechizosMagos(nuevoNombre, antiguoNombre, actualizarMagos());
				cargarMagos();
			}
		
		}
		else if (respuesta.equals("6")) {
			//si se quiere Eliminar Hechizo
		}
		}while (!respuesta.equals("7"));
	}

	private static String actualizarMagos() throws IOException { //guarda todo el txt en una linea separada por ";"
		File arc =new File("txts/Magos.txt"); //para luego re escribirlo todo denuevo 
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
	private static int darDatoHechizos() {
		Scanner s = new Scanner(System.in);
		int dato1 = -413;
		do {
			System.out.print(">");
			dato1 = Integer.parseInt(s.nextLine());
		} while(dato1<1);
		return dato1;
	}
	private static String actualizarHechizos() throws IOException{ //guarda todo el txt em una linea separada por "🦭" :D No hacepto preguntas de porque "
		File arc =new File("txts/Hechizos.txt"); //para luego re escribirlo todo denuevo 
		Scanner sArc = new Scanner(arc);
		String archivo= "No";
		while (sArc.hasNextLine()) {
			String linea= sArc.nextLine();
			if (archivo.equals("No")){
				archivo = linea;
			} else {
				archivo +="🦭"+linea;
			}
			
		}
		return archivo;
	}
}
