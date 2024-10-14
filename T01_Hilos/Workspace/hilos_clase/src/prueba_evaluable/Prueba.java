package prueba_evaluable;

public class Prueba {

	public static void main(String[] args) {
		
		Hilo hilo1 = new Hilo();
		Hilo hilo2 = new Hilo();
		hilo1.setName("Hilo1");
		hilo2.setName("Hilo2");
		hilo1.start();
		hilo2.start();
	}

}
