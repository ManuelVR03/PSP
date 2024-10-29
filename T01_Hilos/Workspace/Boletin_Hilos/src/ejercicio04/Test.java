package ejercicio04;

public class Test {
    public static void main(String[] args) {
        HiloTarea hilo1 = new HiloTarea();
        HiloTarea hilo2 = new HiloTarea();
        hilo1.setName("Thread-0");
        hilo2.setName("Thread-1");

        hilo1.start();
        hilo2.start();
    }
}
