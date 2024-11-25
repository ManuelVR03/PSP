package ejercicio7_sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 7.- Implementar dos aplicaciones tal que una envíe el contenido de un fichero
 * de texto (el cliente) y la otra (el servidor) lea ese fichero de texto y lo
 * muestre por pantalla. Utiliza para ello sockets TCP. El servidor recibe cada
 * línea del fichero e indica n.º de línea y n.º de caracteres de cada línea.
 */

public class Servidor {

	public static void main(String[] args) {
		ServerSocket servidor;
		Socket socket;
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		String linea = "";
		int numLinea = 1;
		System.out.println("Servidor iniciado");
		try {
			servidor = new ServerSocket(PUERTO);
			socket = servidor.accept();
			in = new DataInputStream(socket.getInputStream());

			while (true) {
				try {
					linea = in.readUTF();
					System.out.println("Linea " + numLinea + " (" + linea.length() + " carácteres): " + linea);
					numLinea++;
				} catch (EOFException e) {
					break;
				}

			}
			System.out.println("Servidor cerrado");
			socket.close();
			servidor.close();
		} catch (IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
