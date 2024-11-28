package ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HiloHumedad extends Thread{
	
	@Override
	public void run() {
		Scanner teclado = new Scanner(System.in);
		FileWriter fichero;
		BufferedWriter escribir;
		String nombre = "tiempo_hum.txt";
		double hum;
		long inicio = System.currentTimeMillis(), fin;
		try {
			fichero = new FileWriter(nombre);
			escribir = new BufferedWriter(fichero);
			do {
				System.out.println("Introduce % de humedad (0)");
				hum = teclado.nextDouble();
				escribir.write("Humedad: " + hum + "%\n");
				System.out.println("Humedad registrada");
				fin = System.currentTimeMillis();
			}while(fin - inicio < 60000);
			escribir.close();
			fichero.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
