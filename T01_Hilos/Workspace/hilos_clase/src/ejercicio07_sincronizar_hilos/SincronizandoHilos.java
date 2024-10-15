package ejercicio07_sincronizar_hilos;

/**
 * Crear un programa que ejecute dos hilos uno a continuación del otro.
 * Ambos hilos muestran un mensaje 25 veces en pantalla."Ejecutando hilo nº --"
 * Hay que comprobar que no están sincronizados. (ejecuta los hilos como quiere. No llega a terminar la ejecución del hilo 0
 * y va con la del hilo1 y viceversa.
 */

public class SincronizandoHilos {

	public static void main(String[] args) {
		Hilo hilo0 = new Hilo();
		hilo0.start();
		try {
			hilo0.join(); //espera a que el hilo termine o sea interrumpido
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Hilo hilo1 = new Hilo();
		hilo1.start();
		try {
			hilo1.join(); //espera a que el hilo termine o sea interrumpido
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Se terminaron todas las tareas.");

	}

}
