package runnable_lucia;

public class HiloLucia implements Runnable{

	@Override
	public void run() {
		String nombreHilo = Thread.currentThread().getName();
		for (int i = 1; i <= 20; i++) {
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("Kill Hilo");
				break;
			}
			System.out.println("Soy la línea " + i + " en el hilo " + nombreHilo);
			if(i == 5) Thread.currentThread().interrupt();
		}
		
	}

}
