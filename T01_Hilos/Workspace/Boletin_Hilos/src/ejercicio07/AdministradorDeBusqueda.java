package ejercicio07;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class AdministradorDeBusqueda {
    public static void main(String[] args) {
        File directorio = new File("/home/usuario/DAM/PSP/T01_Hilos/Workspace/Boletin_Hilos/src/ejercicio07");

        String palabra1 = "Hilo";
        String palabra2 = "Palmera";

        AtomicInteger contador1 = new AtomicInteger();
        AtomicInteger contador2 = new AtomicInteger();

        BuscadorDeArchivos buscador1 = new BuscadorDeArchivos(directorio, palabra1, contador1);
        BuscadorDeArchivos buscador2 = new BuscadorDeArchivos(directorio, palabra2, contador2);

        buscador1.start();
        buscador2.start();

        try {
            buscador1.join();
            buscador2.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }

        System.out.println("Archivos que contienen la palabra \"" + palabra1 + "\": " + contador1.get());
        System.out.println("Archivos que contienen la palabra \"" + palabra2 + "\": " + contador2.get());
    }
}

