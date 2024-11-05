package ejercicio_02_TCP_Mensajes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejercicio 01:
 * Una aplicación cliente envía un mensaje a una
 * aplicación servidor y el servidor contesta.
 * Cuando el servidor contesta, termina su ejecución.
 * El cliente contesta en azul y el servidor en rojo
 */


public class Cliente02 {
	
	public static final String ANSI_BLUE = "\u001B[34m";
	public static void main(String[] args) {
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		
		DataInputStream in;
		DataOutputStream out;
		try {
			Socket socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF(ANSI_BLUE + "Saludos desde el cliente!!!");
			
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			
			socket.close();
		}catch(IOException e) {
			Logger.getLogger(Servidor02.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	

}
