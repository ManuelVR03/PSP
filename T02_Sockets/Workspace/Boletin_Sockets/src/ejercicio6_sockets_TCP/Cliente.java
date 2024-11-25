package ejercicio6_sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 6.- Implementar dos aplicaciones(cliente/servidor) tal que una envíe un mensaje
numerado al servidor mientras no se indique que no por teclado. El servidor
responderá al mensaje con la cadena “OK” y seguirá esperando mensajes
nuevos del cliente. Mostrar los mensajes por pantalla. Utiliza para ello sockets
TCP.
 */

public class Cliente {

	public static void main(String[] args) {
		
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataInputStream in;
		DataOutputStream out;
		Socket socket;
		Scanner teclado = new Scanner(System.in);
		String mensaje = "";
		String envio = "";
		int cont = 0;

		try {
			socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("Cliente iniciado");
			
			while(true) {
				if(cont != 0) {
					mensaje = in.readUTF();
					System.out.println(mensaje);
				}
				System.out.println("Escribe un mensaje ('no' para salir)");
				mensaje = teclado.nextLine();
				if(mensaje.equalsIgnoreCase("no")) {
					out.writeUTF(mensaje);
					break;
				}else {
					envio = "Mensaje " + cont + ": " + mensaje;
					out.writeUTF(envio);
					cont++;
				}
			}
			System.out.println("Cortamos conexión");
			socket.close();
		}catch(IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
