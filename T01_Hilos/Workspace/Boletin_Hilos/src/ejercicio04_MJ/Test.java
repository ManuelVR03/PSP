package ejercicio04_MJ;

public class Test {

	public static void main(String[] args) {
		Mensaje m = new Mensaje();
		HiloTarea hilo0 = new HiloTarea(m);
		HiloTarea hilo1 = new HiloTarea(m);
		
		hilo0.start();
		hilo1.start();

	}

}
