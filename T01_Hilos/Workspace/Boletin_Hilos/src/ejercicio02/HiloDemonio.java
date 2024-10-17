package ejercicio02;

public class HiloDemonio extends Thread{

	public int num1, num2;
	
	public HiloDemonio(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		setDaemon(true);
	}
	
	public void run() {
		System.out.println("Esta tarea es una aplicación demonio: " + this.isDaemon());
		if (num1 < num2) {
			while (true) {
				System.out.printf("El primer número es: %d%n", num1);
				num1++;
			}
		} else {
			System.out.println("El primer número es igual o mayor que el segundo.");
		}

	}
}
