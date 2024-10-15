package ejercicio_clase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HiloFecha extends Thread{
	
	private Date fechaActual;
	private SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private long inicio = System.currentTimeMillis();
	
	public void run() {
		
		while(System.currentTimeMillis() - inicio < 10000) {
			fechaActual = new Date();
			System.out.println(fecha.format(fechaActual));
		}
	}

}
