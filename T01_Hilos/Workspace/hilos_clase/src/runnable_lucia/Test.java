package runnable_lucia;

public class Test {

	public static void main(String[] args) {
		
		HiloLucia hilo = new HiloLucia();
		Thread t = new Thread(hilo);
		t.setName("Juanita");
		t.start();
		Thread m = new Thread(hilo);
		m.setName("Pelayo");
		m.start();
		
		

	}

}
