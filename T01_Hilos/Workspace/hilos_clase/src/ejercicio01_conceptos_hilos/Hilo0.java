package ejercicio01_conceptos_hilos;

public class Hilo0 extends Thread {
	public void run() {
		System.out.println("Dentro del Hilo:" + this.getName() + ", Prioridad: " + this.getPriority() + ", ID: " + this.getId() );
		hiloEjecutandose();
		try {
			sleep(1000);
		} catch(InterruptedException e) { }
		if (interrupted()) {
			System.out.println("El hilo fue interrumpido");
		}
		System.out.println("Se sale del Hilo:" + this.getName());
	}
	
	public static void main(String args[]) {
		Hilo0 miHilo=new Hilo0();
		miHilo.setName("MIHILO");
		miHilo.start();
		System.out.println("Información del " + miHilo.getName() + ": "+miHilo.toString());
		System.out.println("el hilo se inicia, pero puede que todavía no haya terminiado...");
		try {
			//creo en mi aplicación un retardo de 2 seg
			sleep(2000);
		} catch(InterruptedException e) {}
		
		
		if(miHilo.isAlive()) {
				System.out.println("El hilo " + miHilo.getName() + " se está ejecutando.");
				miHilo.interrupt();
				System.out.println("El hilo " + miHilo.getName() + " se ha interrumpido.");
			}	
		else
				System.out.println("El hilo " + miHilo.getName() + " ha finalizado.");
		System.out.println("Fin de la ejecución del proceso padre");
	}
	
	public void hiloEjecutandose() {
				System.out.println("En este momento la CPU ejecuta: " + currentThread().getName()+ "\n");
	}
}
