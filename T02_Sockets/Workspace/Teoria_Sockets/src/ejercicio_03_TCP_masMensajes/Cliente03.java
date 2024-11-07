package ejercicio_03_TCP_masMensajes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente03 {

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
				System.out.println("Introduce un mensaje para el servidor: Salir(0)");
				mensaje = teclado.nextLine();
				out.writeUTF(mensaje); // Enviar mensaje al servidor

				if (!mensaje.equals("0")) { // Solo esperar respuesta si no es el mensaje de salida
					String escuchar = in.readUTF(); // Recibir respuesta del servidor
					System.out.println("Servidor: " + escuchar);
				}

			} while (!mensaje.equals("0")); // Usar .equals para comparar strings

			socket.close();
		} catch (IOException e) {
			Logger.getLogger(Cliente03.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			teclado.close();
		}
	}

}
