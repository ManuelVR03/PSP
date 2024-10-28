package ejercicio04;

public class Test {

	public static void main(String[] args) {
        HiloTarea hilo1 = new HiloTarea("Thread-0");
        HiloTarea hilo2 = new HiloTarea("Thread-1");

        hilo1.start();
        hilo2.start();
    }

}
