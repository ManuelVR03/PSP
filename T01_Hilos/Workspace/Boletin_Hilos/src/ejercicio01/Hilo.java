package ejercicio01;

import java.util.ArrayList;

public class Hilo implements Runnable{
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) { }
		
		System.out.println("Fin de la ejecución");
	}

	public static void main(String[] args) {
		ArrayList<Thread> hilos = new ArrayList<>();
		for(int i=0; i<3; i++)
			hilos.add(new Thread(new Hilo()));
		for (Thread t: hilos) {
			t.setName("HILO"+t.getId());
		}
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {}
		for (Thread t: hilos) {
			System.out.println("El hilo " + t.getName() + " se está ejecutando.");
			System.out.println("Información del " + t.getName() + ": "+t.toString());
			t.interrupt();
		}
		for (Thread t: hilos) {
			System.out.println("El hilo " + t.getName() + " ha finalizado.");
		}
		

	}

	

}
