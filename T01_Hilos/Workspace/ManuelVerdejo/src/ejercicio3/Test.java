package ejercicio3;

public class Test {

	public static void main(String[] args) {
		Hilo1 hilo1 = new Hilo1();
		Hilo2 hilo2 = new Hilo2();
		Hilo3 hilo3 = new Hilo3();
		hilo1.start();
		hilo2.start();
		hilo3.start();
		System.out.println("Se han creado los ficheros correspondientes.");

	}

}
