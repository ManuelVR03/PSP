package ejercicio_clase;

public class SincronizandoHilos {

	public static void main(String[] args) {
		HiloFecha hilo1 = new HiloFecha();
		Hilo hilo0 = new Hilo();
		
		hilo1.start();
		try {
			hilo1.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo0.start();
		try {
			hilo0.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Se terminaron todas las tareas.");

	}

}
