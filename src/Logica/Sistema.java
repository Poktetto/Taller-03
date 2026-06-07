package Logica;

import java.io.IOException;

public interface Sistema {
	/**
	 * Crea el objeto de hechizo dependiendo de su tipo y lo almacena
	 * 
	 * PRE:
	 * - El String debe estar separado por 3 ";" y la cuarta parte puede debe estar separada por un "," 
	 *   si indica que es de ciertos tipos
	 * POST:
	 * - Se crea el hechizo dependiendo sus caracteristicas y se almacena en una ArrayList 
	 * @param linea La linea proveniente del txt para crear el hechizo
	 */
	void crearHechizo(String linea);
	/**
	 *  * Crea el objeto de mago con la lista de sus hechizos y lo almacena
	 * 
	 * PRE:
	 * - El String debe estar separado por 1 ";" y la 2 parte puede debe estar separada por uno o más "|" 
	 *   para separar los hechizos 
	 * POST:
	 * - Se crea el mago con sus hechizos y se almacena en una ArrayList 
	 * @param linea La linea proveniente del txt para crear el mago
	 */
	void crearMago(String linea);
	
	void agregarMago(String nombreMago,String lineaHechizos, String linea) throws IOException;
	String mostrarMagos(int i);
	String mostrarHechizos(int i);
	
	int cantidadHechizos();
	
	String unionHechizosMagos(String aniadirHechizo, String Linea);
	
	int cantidadMagos();
	void agregarHechizo(int numeroMago, String aniadirHechizo);


}
