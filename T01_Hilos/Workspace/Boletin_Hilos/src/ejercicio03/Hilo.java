package ejercicio03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Hilo extends Thread{

	String nombreArchivo;
	int numeroHilo;
	
	public Hilo(String nombreArchivo, int numeroHilo) {
		this.nombreArchivo = nombreArchivo;
		this.numeroHilo = numeroHilo;
	}
	
	@Override
    public void run() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nombreArchivo))) {
        	int i2 = 1;
        	if(isDaemon())
        		while(true) {
        			bufferedWriter.write(i2 + "\n");
        			i2++;
        		}
        	else
        		for (int i = 0; i <= 10000; i++) {
        			bufferedWriter.write(i + "\n");
        		}
            System.out.println("Hilo " + numeroHilo + " ha terminado de crear el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo " + nombreArchivo);
            e.printStackTrace();
        }
    }
	
	
}
