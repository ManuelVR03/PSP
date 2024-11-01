package ejercicio07_VR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hilo extends Thread {
	private String palabra;
	private String rutaAcceso;
	private int cont;

	public Hilo(String palabra, String rutaAcceso) {
		this.palabra = palabra;
		this.rutaAcceso = rutaAcceso;
		this.cont = 0;
	}

	@Override
	public void run() {
		try {
			lectura();
		} catch (IOException e) {
			e.getMessage();
		}
		System.out.println("La palabra " + palabra + " ha sido encontrada " + cont + " veces.");
	}

	public void lectura() throws IOException {

		// Declaraciones
		FileReader fr = null;
		BufferedReader br = null;
		List<String> ficherosTxt = new ArrayList<String>();
		String linea = "";
		File direc = new File(rutaAcceso);
		boolean enc = false;

		// Busqueda de ficheros

		if (direc.isDirectory()) {
			File[] contenido = direc.listFiles();
			for (File f : contenido) {
				int punto = f.getName().lastIndexOf(".");
				int longitud = f.getName().length();
				if (punto != -1 && punto > 0) {
					String formato = f.getName().substring(punto, longitud); // .txt .exe
					if (formato.equals(".txt")) {
						ficherosTxt.add(f.getName()); // programacion.txt
					}
				}
			}

			// tratamiento de busqueda de la palabra en ficheros
			try {
			// 1.Apertura del fichero
				for (String s : ficherosTxt) {
					enc = false;
					fr = new FileReader(rutaAcceso+"/"+s);
					br = new BufferedReader(fr);

					// 2.Tratamiento del fichero

					while (br.ready() && !enc) {// comprueba si hay + datos para leer
						linea = br.readLine(); // lee una linea hasta el \n
						if (linea.contains(palabra)) { // comprueba que la palabra sea igual a la que buscamos
							cont++;
							enc = true;
						}
					}
				}

			// 3.Clausura del fichero -->Se cierra 1ยบ el buffered y desp el fichero

			} catch (IOException e) { 
				// sirve para excepciones de errores como:
				// no existe el fichero
				// no tenemos permiso para leer
				// no tenemos memoria
				e.printStackTrace();

			} finally {
				br.close();
				fr.close();
			}
		}
	}

	public int getCont() {
		return cont;
	}

	// cada vez que tenga una lectura(un .read hay que comprobar 1ยบ que haya datos)

}
