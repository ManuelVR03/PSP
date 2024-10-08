package ejercicio01_conceptos_hilos;



public class Hilo0Runnable implements Runnable {
	public void run() {
		
		hiloEjecutandose();
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) { }
		
		System.out.println("Se sale del Hilo" );
	}
	
	
	
	public static void main(String args[]) {
		
		Runnable r= new Hilo0Runnable();
		
		Thread miHilo=new Thread(r);
				
		miHilo.setName("MIHILO");
		miHilo.start();
		System.out.println("Información del " + miHilo.getName() + ": "+miHilo.toString());
		System.out.println("el hilo se inicia, pero puede que todavía no haya terminiado...");
		try {
			//creo en mi aplicación un retardo de 2 seg
			Thread.sleep(2000);
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
				System.out.println("En este momento la CPU ejecuta el hilo\n");
	}
}
