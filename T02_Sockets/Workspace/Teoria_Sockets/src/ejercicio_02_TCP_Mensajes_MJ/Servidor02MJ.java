package ejercicio_02_TCP_Mensajes_MJ;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor02MJ {

    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
    	ServerSocket servidor = null;
    	Socket socket = null;
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        System.out.println(ANSI_RED + "Servidor iniciado");

        try {
            servidor = new ServerSocket(PUERTO);
            

            while (true) {  // Mantener el servidor siempre a la escucha
            	socket = servidor.accept();
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                out.writeUTF(ANSI_RED + "OK ");
                in.close();
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            Logger.getLogger(Servidor02MJ.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}