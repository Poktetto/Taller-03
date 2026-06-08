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
	/**
	 * Agrega una linea un mago al txt
	 * 
	 * PRE:
	 * - El String lineaHechizos debe estar separado por "|"
	 * POST:
	 * -Guarda en el txt todos los magos incluyendo el nuevo
	 * 
	 * @param nombreMago Nombre del nuebo mago
	 * @param lineaHechizos La linea de hechizos separados por "|"
	 * @param linea El txt completo separado por "🐟"
	 * @throws IOException en caso de ausencia de error en el writer
	 */
	void agregarMago(String nombreMago,String lineaHechizos, String linea) throws IOException;
	/**
	 *  Busca en la lista de magos y debuelve el mago junto a su indice
	 *  PRE:
	 *  -la lista hechizo tenga tal indice
	 *  POST:
	 *  -regresa el indice
	 * @param i indice indicado 
	 * @return el texto Mago del Indice indicado
	 */
	String mostrarMagos(int i);
	/**
	 *  Busca en la lista de hechhizos y debuelve el nombre de el hechizos del indice
	 *  -la lista hechizo tenga tal indice
	 *  POST:
	 *  -regresa el indice
	 * @param i indice indicado
	 * @return el nombre del hechizo del indice
	 */
	String mostrarHechizos(int i);
	/**
	 * agrega una linea de hechizo al txt
	 * PRE:
	 * -El hechizoNuevo debe cumplir con la normas de escritura de hechizos
	 * POST:
	 * -guarda en el txt todos los hechizos incluyendo el nuevo
	 * 
	 * @param hechizoNuevo la linea de hechizo completo
	 * @param linea el archivo txt separado por "🦭"
	 * @throws IOException en caso de ausencia de error en el writer
	 */
	void agregarHechizoTxt(String hechizoNuevo, String linea) throws IOException;
	/**
	 * muestra el tipo de hechizo del indice indicado
	 * PRE:
	 * -Que la lista tenga este indice
	 * POST:
	 * -Regresa el tipo del indice
	 * @param i indice que se busca
	 * @return el tipo del hechizo del indice indicado
	 */
	String mostrarTipoHechizo(int i);
	//IMPORTANTE
	/**
	 * escribir despues 
	 * PRE:
	 * -
	 * POST:
	 * -
	 * @param tipo el tipo de modificacion realizada 
	 * @param datoEntrada el dato al cual se va a poner el cambio Ej: nuevo Nombre
	 * @param Linea el txt completo seprarado por "🦭"
	 * @param nombreOriginal el nombre del hechizo al cual se quiere hacer los cambios
	 * @throws IOException en caso de ausencia de error en el writer
	 */
	void modificarHechizo(int tipo, String datoEntrada, String Linea, String nombreOriginal) throws IOException;
	/**
	 * recorre la lista y debuelve el tamaño de esta 
	 * PRE:
	 * -none
	 * POST:
	 * -regresa el tamaño de la lista hechizos
	 * @return tamaño lista hechizos
	 */
	int cantidadHechizos();
	/**
	 * junta los diferentes hechizos de los magos bajo las normas de escritura del txt
	 * PRE:
	 * -None
	 * POST:
	 * @param aniadirHechizo el hechizo entrante
	 * @param linea el total de hechizos en linea del mago
	 * @return el total de hechizos del mago
	 */
	String unionHechizosMagos(String aniadirHechizo, String linea);
	/**
	 * regresa el nimero total de la lista de magos
	 * PRE:
	 * -None
	 * POST:
	 * -int que es el tamaño de la lista de magos 
	 * @return el tamaño de la lista de magos
	 */
	int cantidadMagos();
	/**
	 * agrega el hechizo en la lista de hechizos del mago
	 * PRE:
	 * -None
	 * Post:
	 * -se agrega el hechizo a la lista de hechizos del mago
	 * @param numeroMago indice del mago 
	 * @param aniadirHechizo hcehcizo a añadir
	 */
	void agregarHechizo(int numeroMago, int aniadirHechizo);
	/**
	 * sobrescribe el mago con los nuevos hechhizos
	 *  * PRE:
	 * -que exusta mago indice numeroMago
	 * POST:
	 * 	 * -re escribe todo el txt con el mago modificado
	 * @param numeroMago indice mago modificado
	 * @param nuevoHechizo nombre del nuevo hechizo
	 * @param linea todo el txt separado por "🐟"
	 * @throws IOExceptio nen caso de ausencia de error en el writer
	 */
	public void modificarMago(int numeroMago, String nuevoHechizo, String linea)throws IOException;
	/**
	 * Elimina el mago del indice y luego rescribe todo el txt
	 * PRE:
	 * -que exista el mago del indice
	 * POST:
	 * -el txt sin el mago del indice
	 * @param indiceMago a eliminar 
	 * @param linea todo el txt separado por "🐟"
	 * @throws IOException en caso de ausencia de error en el writer
	 */
	void eliminarMago(int indiceMago, String linea) throws IOException;
	/**
	 * muestra la cantidad de hechizos en la lista de hcechizos del mago 
	 * PRE:
	 * -none
	 * POST:
	 * - muestra la cantidad de hechizos en la lista de hcechizos del mago 
	 * @param numeroMago indice mago
	 * @return la cantidad de hechizos en la lista de hcechizos del mago 
	 */
	int cantidadHechizos(int numeroMago);
	/**
	 * muestra los hechizos de la lista hechizos del mago
	 * PRE:
	 * -mone
	 * POST:
	 * -String conteniendo el indice y el nombre del hechizo del mago que es indicado por i
	 * @param i indice del hechizo a retornar
	 * @param numeroMago indice del mago 
	 * @return String conteniendo el indice y el nombre del hechizo del mago que es indicado por i
	 */
	String mostrarMagosHechizo(int i, int numeroMago);
	/**
	 * borra el hechizo de la lista de hechizos del mago
	 * PRE:
	 * -que el mago tenga hechizo numeroHechizo
	 * POST:
	 * -elimina el hechizo de la lista de hechizos del mago
	 * @param numeroMago indice mago
	 * @param numeroHechizo indice hechizo a eliminar de la lista de hechizos del mago
	 */
	void eliminarHechizo(int numeroMago, int numeroHechizo);
	/**
	 * borrar y sobreescribir el mago con el indice del hechzo
	 * PRE:
	 * -que exusta mago indice numeroMago
	 * POST:
	 * -re escribe todo el txt con el mago modificado
	 * @param numeroMago indice mago modificado
	 * @param numeroHechizo indice hechizo a eliminar
	 * @param linea todo el txt separado por "🐟"
	 * @throws IOException en caso de ausencia de error en el writer
	 */
	void modificarMago(int numeroMago,int numeroHechizo, String linea)throws IOException;
	
	void actualizarHechizosMagos(String nuevoNombre, String antiguoNombre, String linea)throws IOException;


}
