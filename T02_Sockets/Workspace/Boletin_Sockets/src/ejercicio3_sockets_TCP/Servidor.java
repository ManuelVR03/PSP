package ejercicio3_sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
	public static void main(String[] args) {
		ServerSocket servidor;
		Socket socket;
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		int cuadrado;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			socket = servidor.accept();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			do {
                cuadrado = in.readInt();  // Leer número del cliente
                if (cuadrado != 0) {
                    cuadrado *= cuadrado;
                    out.writeInt(cuadrado);  // Enviar cuadrado al cliente
                    System.out.println("Enviado el cuadrado");
                }
            } while (cuadrado != 0);

			socket.close();
			servidor.close();

		} catch (IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
