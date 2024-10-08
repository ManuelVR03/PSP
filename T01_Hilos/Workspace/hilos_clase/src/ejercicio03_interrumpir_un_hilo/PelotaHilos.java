package ejercicio03_interrumpir_un_hilo;

import java.awt.Component;

public class PelotaHilos implements Runnable{
	
	private Pelota pelota;
	private Component componente;

	@Override
	public void run() {
		for (int i=1; i<=3000; i++) {
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			try {
				Thread.sleep(4);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public PelotaHilos(Pelota pelota, Component componente) {
		super();
		this.pelota = pelota;
		this.componente = componente;
	}

}
