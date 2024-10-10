package ejercicio06_hilos_sin_sincronizar;

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
		
		Hilo hilo1 = new Hilo();
		hilo1.start();

	}

}
