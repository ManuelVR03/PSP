package ejercicio_02_TCP_Mensajes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor02 {

    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        final int PUERTO = 5000;

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println(ANSI_RED + "Servidor iniciado");

            while (true) {  // Mantener el servidor siempre a la escucha
                Socket socket = servidor.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                int cont = 1;
                String mensaje;

                // Leer mensajes mientras no se reciba el mensaje de salida "0"
                while (!(mensaje = in.readUTF()).equals("0")) {
                    System.out.println("Mensaje " + cont + ": " + mensaje);
                    cont++;
                    out.writeUTF("OK");
                }

                System.out.println("Cliente desconectado.");
                socket.close();
            }
        } catch (IOException e) {
            Logger.getLogger(Servidor02.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}