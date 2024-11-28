package ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HiloTemperatura extends Thread{
	
	@Override
	public void run() {
		Scanner teclado = new Scanner(System.in);
		FileWriter fichero;
		BufferedWriter escribir;
		String nombre = "tiempo_temp.txt";
		double temp;
		long inicio = System.currentTimeMillis(), fin;
		try {
			fichero = new FileWriter(nombre);
			escribir = new BufferedWriter(fichero);
			do {
				System.out.println("Introduce una temperatura en ºC");
				temp = teclado.nextDouble();
				escribir.write("Temperatura: " + temp + "ºC\n");
				System.out.println("Temperatura registrada");
				fin = System.currentTimeMillis();
			}while(fin - inicio < 60000);
			escribir.close();
			fichero.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
