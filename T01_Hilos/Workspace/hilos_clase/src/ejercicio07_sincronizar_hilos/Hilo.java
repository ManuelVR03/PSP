package ejercicio07_sincronizar_hilos;

public class Hilo extends Thread{

	public void run() {
		for(int i = 0; i < 25; i++) {
			System.out.println("Ejecutando el hilo nº " + getName());
		}
	}
}
