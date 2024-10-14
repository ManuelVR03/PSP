package prueba_evaluable;

import java.util.Date;

public class Hilo extends Thread{
	private String cadena = "";
	private int suma = 0;
	Date fecha = new Date();

	public void run() {
		switch(getName()) {
			case "Hilo1":
				for(int i = 1; i <= 20; i++) {
					suma = i + suma;
					cadena += suma + " "; 
					System.out.println(cadena);
				}
				break;
			case "Hilo2":
				for(int i = 0; i < 20; i++) {
					System.out.println(fecha);
				}
				break;
			default:
				System.out.println("Ejecución no programada.");
		}
		
		
		
			
	}
}
