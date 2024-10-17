package ejercicio02;

public class Hilo extends Thread{

	public int num1, num2;
	
	public Hilo(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public void run() {
		System.out.println("Esta tarea es una aplicacion demonio: " + this.isDaemon());
		if(num1 < num2) {
		while(num1 < num2) {
			System.out.printf("El primer número es: %d%n", num1);
			num1++;
		}
		}else {
			System.out.println("El primer número es igual o mayor que el segundo.");
		}
		System.out.println("*****************************************************");
		
	}
}
