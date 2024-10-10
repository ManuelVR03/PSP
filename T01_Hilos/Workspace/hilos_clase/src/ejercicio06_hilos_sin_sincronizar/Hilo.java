package ejercicio06_hilos_sin_sincronizar;

public class Hilo extends Thread{

	public void run() {
		for(int i = 0; i < 25; i++) {
			System.out.println("Ejecutando el hilo nº " + getName());
		}
	}
}
