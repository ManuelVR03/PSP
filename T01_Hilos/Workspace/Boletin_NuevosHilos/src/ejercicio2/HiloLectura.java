package ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HiloLectura extends Thread {

	@Override
	public void run() {
		String linea;
		FileReader fichero;
		BufferedReader leer;
		try {
			fichero = new FileReader(
					"/home/usuario/DAM/PSP/T01_Hilos/Workspace/Boletin_NuevosHilos/src/ejercicio2/ejercicio2.txt");
			leer = new BufferedReader(fichero);

			while (leer.ready()) {
				synchronized (leer) {
					linea = leer.readLine();
					if (this.getName().equals("hiloMY"))
						System.out.println(linea.toUpperCase());
					else
						System.out.println(linea.toLowerCase());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
