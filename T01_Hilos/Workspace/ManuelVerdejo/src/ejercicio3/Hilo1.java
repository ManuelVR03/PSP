package ejercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Hilo1 extends Thread{

	@Override
	public void run() {
		FileWriter fichero;
		BufferedWriter escribir;
		int num;
		try {
			fichero = new FileWriter("fichero1.txt");
			escribir = new BufferedWriter(fichero);
			for(int i = 0; i < 50; i++) {
				num = (int) (Math.random()*10+1);
				escribir.write(""+num+"\n");
			}
			escribir.close();
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}