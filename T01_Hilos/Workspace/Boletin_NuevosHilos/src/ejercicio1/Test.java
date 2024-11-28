package ejercicio1;

public class Test {

	/*
	 * Realiza una aplicación Java en consola que realice las siguientes tareas
	 * (cada tarea es un hilo) de forma simultánea: - lea las temperaturas ocurridas
	 * en un minuto ( en nuestro ejercicio simulamos la lectura de datos pidiéndolos
	 * por teclado) y escriba los datos que va recibiendo en cada momento en el
	 * fichero “tiempo_temp.txt” - lea el grado de humedad ocurrida en un minuto (
	 * en nuestro ejercicio simulamos la lectura de datos pidiéndolos por teclado) y
	 * escriba los datos que va recibiendo en cada momento en el fichero
	 * “tiempo_hum.txt”
	 */

	public static void main(String[] args) {
		HiloTemperatura temperatura = new HiloTemperatura();
		HiloHumedad humedad = new HiloHumedad();
		
		temperatura.start();
		humedad.start();
	}

}
