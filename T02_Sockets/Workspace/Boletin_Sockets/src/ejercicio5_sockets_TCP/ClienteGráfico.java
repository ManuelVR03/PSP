package ejercicio5_sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 5.- Implementar un servidor utilizando tecnología Sockets JAVA TCP que permita
realizar las operaciones aritméticas básicas. Igualmente implementar un cliente
que haga uso del servicio. Crear un cliente para consola y otro cliente gráfico.
 */

public class ClienteGráfico {

	public static void main(String[] args) {
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataInputStream in;
		Socket socket;
		float resultado;
		
		try {
			socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			
			while(true) {
				resultado = in.readFloat();
				System.out.println("El resultado de la operación es: " + resultado);
			}
			
		}catch(IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
