package ejercicio07;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;

public class BuscadorDeArchivos extends Thread {
    private final File directorio;
    private final String palabra;
    private final AtomicInteger contador;

    public BuscadorDeArchivos(File directorio, String palabra, AtomicInteger contador) {
        this.directorio = directorio;
        this.palabra = palabra;
        this.contador = contador;
    }

    @Override
    public void run() {
        buscarEnDirectorio(directorio);
    }

    private void buscarEnDirectorio(File dir) {
        File[] archivos = dir.listFiles((archivo) -> archivo.isFile() && archivo.getName().endsWith(".txt"));
        if (archivos != null) {
            for (File archivo : archivos) {
                if (contienePalabra(archivo, palabra)) {
                    contador.incrementAndGet();
                }
            }
        }
    }

    private boolean contienePalabra(File archivo, String palabra) {
        try {
            return Files.lines(archivo.toPath()).anyMatch(linea -> linea.contains(palabra));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + archivo.getName());
            return false;
        }
    }
}

