package ejercicio03;

/*
 *3.- Diseñar un programa en modo consola que cree tres ficheros de texto con
los números del 0 al 10000. El primer fichero tiene una prioridad máxima con
respecto al segundo y la creación del tercer fichero debe ser en segundo plano.
Comprobar cuándo finaliza la creación de cada fichero con un mensaje en
consola. 
 */

public class Ejecutable {

	public static void main(String[] args) {
		Hilo hilo1 = new Hilo("fichero1.txt", 1);
		Hilo hilo2 = new Hilo("fichero2.txt", 2);
		Hilo hilo3 = new Hilo("fichero3.txt", 3);
		
		hilo1.setPriority(Thread.MAX_PRIORITY);
		hilo2.setPriority(Thread.NORM_PRIORITY);
		hilo3.setPriority(Thread.MIN_PRIORITY);
		hilo3.setDaemon(true);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();

	}

}
