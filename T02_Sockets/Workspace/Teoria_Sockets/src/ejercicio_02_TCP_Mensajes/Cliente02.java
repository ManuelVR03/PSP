package ejercicio_02_TCP_Mensajes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejercicio 02:
 * Una aplicación cliente envía mensajes a una
 * aplicación servidor y el servidor contesta.
 */


public class Cliente02 {

    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        final int PUERTO = 5000;
        final String HOST = "127.0.0.1";
        Scanner teclado = new Scanner(System.in);

        try {
            Socket socket = new Socket(HOST, PUERTO);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String mensaje;

            do {
                System.out.println("Introduce un mensaje para el servidor: ");
                mensaje = teclado.nextLine();
                out.writeUTF(mensaje);  // Enviar mensaje al servidor

                if (!mensaje.equals("0")) {  // Solo esperar respuesta si no es el mensaje de salida
                    String escuchar = in.readUTF();  // Recibir respuesta del servidor
                    System.out.println("Servidor: " + escuchar);
                }

            } while (!mensaje.equals("0"));  // Usar .equals para comparar strings

            socket.close();
        } catch (IOException e) {
            Logger.getLogger(Cliente02.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            teclado.close();
        }
    }
}