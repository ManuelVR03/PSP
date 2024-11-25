package ejercicio6_sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 6.- Implementar dos aplicaciones(cliente/servidor) tal que una envíe un mensaje
numerado al servidor mientras no se indique que no por teclado. El servidor
responderá al mensaje con la cadena “OK” y seguirá esperando mensajes
nuevos del cliente. Mostrar los mensajes por pantalla. Utiliza para ello sockets
TCP.
 */

public class Servidor {

	public static void main(String[] args) {
		ServerSocket servidor;
		Socket socket;
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		String mensaje = "";
		System.out.println("Servidor iniciado");
		try {
			servidor = new ServerSocket(PUERTO);
			socket = servidor.accept();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			while(true) {
				mensaje = in.readUTF();
				if(mensaje.equalsIgnoreCase("no")) break;
				System.out.println(mensaje);
				out.writeUTF("OK");
			}
			System.out.println("Servidor cerrado");
			socket.close();
			servidor.close();
		}catch (IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
