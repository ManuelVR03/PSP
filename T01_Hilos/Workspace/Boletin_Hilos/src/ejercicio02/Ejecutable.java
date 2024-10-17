package ejercicio02;

import java.util.Scanner;

public class Ejecutable {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num1 = 0, num2 = 0;
		System.out.println("Introduce un número: ");
		num1 = teclado.nextInt();
		System.out.println("Introduce otro número: ");
		num2 = teclado.nextInt();

		Hilo hilo0 = new Hilo(num1, num2);
		HiloDemonio hilo1 = new HiloDemonio(num1, num2);
		hilo0.start();
		hilo1.start();

	}

}
