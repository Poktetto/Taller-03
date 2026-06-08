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
			String[] parteEspecifica = partes[3].split(","); //para la parte final que se divide en 2 
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
		return i+1+") "+ magos.get(i).toString();
	}
	public String mostrarMagosHechizo(int i, int numeroMago) {
	
		return i+1+") "+ magos.get(numeroMago).getHechizoPorI(i);
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
	public int cantidadHechizos(int numeroMago) {
		return magos.get(numeroMago).tamanioHechizosM();
		
	}
	@Override
	public String unionHechizosMagos(String aniadirHechizo, String lineaHechizos) { //en añadir mago
		if (lineaHechizos==null) {
			lineaHechizos = mostrarHechizos(Integer.parseInt(aniadirHechizo)-1);
			return lineaHechizos;
		} else {
			lineaHechizos += "|" + mostrarHechizos(Integer.parseInt(aniadirHechizo)-1);
			return lineaHechizos;
		}	
	}
	
	private String unionHechizosMagos(String []listaHechizos,int numeroHechizo) { //en eliminar hechizo de un mago
		 String lineaHechizos = "";
		    boolean primerHechizo = true;
		    for (int j = 0; j < listaHechizos.length; j++) {
		        // Si es el hechizo que el usuario quiere borrar, lo ignoramos
		        if (j == numeroHechizo) {
		            continue;
		        }

		        if (primerHechizo) {
		        	lineaHechizos += listaHechizos[j];
		            primerHechizo = false;
		        } else {
		        	lineaHechizos += "|" +listaHechizos[j];
		        }
		    }
		    return lineaHechizos;	
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
	
	public void agregarHechizo(int numeroMago, int numeroHechizo) {
		
		magos.get(numeroMago).agregarHechizo(hechizos.get(numeroHechizo).getNombre()); //agrega el hechizo en la lista de hechizos del mago
		
	}
	@Override
	public void eliminarHechizo(int numeroMago, int numeroHechizo) {
		magos.get(numeroMago).getHechizosM().remove(numeroHechizo);//bora el hechizo
	}
	
	public void modificarMago(int numeroMago,int numeroHechizo, String linea) throws IOException { //al eliminar hechizo
			FileWriter writerRegistro = new FileWriter("txts/Magos.txt",false); 
	    BufferedWriter escritor = new BufferedWriter(writerRegistro);
	    
	    String[] partes = linea.split("🐟");

	    
	    for (int i = 0; i < partes.length; i++) {
	        String lineaMago = partes[i]; 
	        if (i == (numeroMago )) {
	            String[] part2 = lineaMago.split(";"); 
	            String nombreMago = part2[0]; //nombre del mago
	            
	            if (part2.length >= 2 && !part2[1].isEmpty()) {
	                String[] listaHechizos = part2[1].split("\\|"); // \\para que lea bien
	                
	                String nuevosHechizos = unionHechizosMagos(listaHechizos, numeroHechizo);
	                lineaMago = nombreMago + ";" + nuevosHechizos;
	            }
	        }
	                
	        escritor.write(lineaMago);
	        if (i < partes.length - 1) {
	            escritor.newLine(); //para evitar espacios
	        	}
	        }
	    escritor.close();
	}// logra borrar y sobreescribir el mago
	
	
	
	public void modificarMago(int numeroMago, String nuevoHechizo, String linea) throws IOException {//al agregar hechizo
		magos.clear();
		
		FileWriter writerRegistro = new FileWriter("txts/Magos.txt"); 
	    BufferedWriter escritor = new BufferedWriter(writerRegistro);
	    escritor.close();
	    
	    String[] partes = linea.split("🐟");
	    
	    for (int i = 0; i < partes.length; i++) {
	        String lineaMagoActual = partes[i];
	        if (i == (numeroMago)) {
	        	lineaMagoActual = lineaMagoActual + "|" + nuevoHechizo;
	        
	        }
	        
	        recargarTxtMagos(lineaMagoActual, i == 0);
	    }
	}
	private void recargarTxtMagos(String linea, boolean primerMago) throws IOException {
		FileWriter writerRegistro = new FileWriter("txts/Magos.txt",true); //escibe más elementos
		BufferedWriter escritor =new BufferedWriter(writerRegistro); 
		if (!primerMago) {
	        escritor.newLine(); // 
	    }//salta de linea
		escritor.write(linea); //rescribe la linea que probiende de la funcion de los "🐟"
		escritor.close();
		
	}
	@Override
	public void eliminarMago(int indiceMago, String linea) throws IOException {
		int cantMagos = magos.size(); 
		FileWriter writerRegistro = new FileWriter("txts/Magos.txt"); //reiniciar el txt
		BufferedWriter escritor =new BufferedWriter(writerRegistro); 
		String[] partes =linea.split("🐟"); 
		String[] magoPartes = partes[0].split(";");
		//lee el primer mago y ve si es igual 
		int inicio=1;
		if(!magos.get(indiceMago).getNombre().equals(magoPartes[0])) {
			escritor.write(partes[0]); //lo escribe
			//esto se hace para no crear otro recargarTxtMagos sin el newLine al inicio
		} else {
			escritor.write(partes[1]); //rescribe el segundo e indica que lo hizo
			inicio=2;
		}
		escritor.close();
		for (int i=inicio; i<cantMagos;i++) { //ciclo por el total antiguo de magos 
			magoPartes= partes[i].split(";"); // separa el mago en partes para conocer su nombre
			
			if (!magos.get(indiceMago).getNombre().equals(magoPartes[0])) { //si sus nombres coinciden
				recargarTxtMagos(partes[i]);
			}
		}
		magos.clear();
	}
	@Override
	public void agregarHechizoTxt(String hechizoNuevo, String linea) throws IOException {
		int cantHechizos = hechizos.size();
		hechizos.clear();
		FileWriter writerRegistro = new FileWriter("txts/Hechizos.txt");
		BufferedWriter escritor =new BufferedWriter(writerRegistro); 
		escritor.write(hechizoNuevo); //escribe el nuevo hechizo
		escritor.close();
		String[] partes =linea.split("🦭"); //"🦭🦭🦭"
		for (int i=0; i<cantHechizos;i++) { 
			recargarTxtHechizos(partes[i]); 
		} 
	}
	private void recargarTxtHechizos(String linea) throws IOException {
		FileWriter writerRegistro = new FileWriter("txts/Hechizos.txt",true);
		BufferedWriter escritor =new BufferedWriter(writerRegistro); 
		escritor.newLine(); 
		escritor.write(linea); 
		escritor.close(); 
		
		
	}
	private void recargarTxtHechizos(String linea, boolean primeraLinea) throws IOException {
		FileWriter writerRegistro = new FileWriter("txts/Hechizos.txt",true);
		BufferedWriter escritor =new BufferedWriter(writerRegistro); 
		if (!primeraLinea) {
			escritor.newLine(); 
		}
	
		escritor.write(linea); 
		escritor.close(); 
		
		
	}
	@Override
	public String mostrarTipoHechizo(int i) {
		return hechizos.get(i).getTipo();
	}
	public void modificarHechizo(int tipo, String datoEntrada, String linea, String nombreOriginal) throws IOException {
		String[] partes =linea.split("🦭");
		int cantHechizos = hechizos.size();
		hechizos.clear();
		FileWriter writerRegistro = new FileWriter("txts/Hechizos.txt");
		BufferedWriter escritor =new BufferedWriter(writerRegistro); 
		escritor.close();
		if (tipo==1) {
			for (int i=0;i<cantHechizos;i++) {
				String[] partesHechizo=partes[i].split(";");
				if (nombreOriginal.equals(partesHechizo[0])) {
					
					FileWriter writerRegistro2 = new FileWriter("txts/Hechizos.txt",true);
					BufferedWriter escritor2 =new BufferedWriter(writerRegistro2); 
					if (i!=0) {
						escritor2.newLine();
					}
					escritor2.write(datoEntrada+";"+partesHechizo[1]+";"+partesHechizo[2]+";"+partesHechizo[3]);
					escritor2.close();
				} else {
					boolean primeraLinea=false;
					if (i==0) {
						primeraLinea=true;
					}
					recargarTxtHechizos(partes[i],primeraLinea);
					
				}
			}
			
		}
		
	}



}
