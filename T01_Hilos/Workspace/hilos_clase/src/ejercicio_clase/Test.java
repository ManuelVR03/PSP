package ejercicio_clase;

public class Test {

	public static void main(String[] args) {
		Hilo hilo0 = new Hilo();
		hilo0.start();
		
		HiloFecha hilo1 = new HiloFecha();
		hilo1.start();

	}

}
