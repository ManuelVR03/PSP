package ejercicio02;

public class HiloDemonio extends Thread{

	public int num1, num2;
	
	public HiloDemonio(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		setDaemon(true);
	}
	
	public void run() {
		System.out.println(getName() + ": Esta tarea es una aplicacion demonio: " + this.isDaemon());
		if(num1 < num2) {
		while(true) {
			System.out.printf(getName() + ": El primer número es: %d%n", num1);
			num1++;
		}
		}else {
			System.out.println(getName() + ": El primer número es igual o mayor que el segundo.");
		}
		System.out.println("*****************************************************");
	}
}
