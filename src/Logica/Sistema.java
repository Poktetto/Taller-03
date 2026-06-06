package Logica;

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
}
