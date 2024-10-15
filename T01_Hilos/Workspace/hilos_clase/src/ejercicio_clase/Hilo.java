package ejercicio_clase;

public class Hilo extends Thread{
	
	private int suma = 0;
	private String cadena = "";

	public void run () {
		for(int i = 1; i <= 20; i++) {
			suma = i + suma;
			cadena += suma + " "; 
			System.out.println(cadena);
		}
	}
}
