package ejercicio04_interrumpir_solo_ultimo_hilo;

import java.awt.Component;

public class PelotaHilos implements Runnable{
	
	private Pelota pelota;
	private Component componente;

	@Override
	public void run() {
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
		//for (int i=1; i<=3000; i++) {
		while(!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			try {
				Thread.sleep(4);
			}catch (InterruptedException e) {
				//e.printStackTrace();
				Thread.currentThread().interrupt();
			}		
		}
		System.out.println("Estado del hilo al finalizar: " + Thread.currentThread().isInterrupted());
			
		//}
	}
	
	public PelotaHilos(Pelota pelota, Component componente) {
		super();
		this.pelota = pelota;
		this.componente = componente;
	}

}
