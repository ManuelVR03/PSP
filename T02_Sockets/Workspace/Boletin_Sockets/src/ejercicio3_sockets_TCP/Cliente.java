package ejercicio3_sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 3.- Implementar un servidor utilizando tecnología Sockets JAVA TCP que
 * permita leer un número y devuelva al cliente el cuadrado del número.
 * Implementar también el cliente.
 */

public class Cliente {

	public static void main(String[] args) {
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataInputStream in;
		DataOutputStream out;
		Socket socket;
		Scanner teclado = new Scanner(System.in);
		int cuadrado;
		int escuchar;
		
		try {
			socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			do {
                System.out.println("Introduce un número para saber su cuadrado: ");
                cuadrado = teclado.nextInt();
                out.writeInt(cuadrado);  // Enviar mensaje al servidor

                if (cuadrado != 0) {  // Solo esperar respuesta si no es el mensaje de salida
                    escuchar = in.readInt();  // Recibir respuesta del servidor
                    System.out.println("El cuadrado de " + cuadrado + " es " + escuchar);
                }

            } while (cuadrado != 0);
			
			socket.close();
			teclado.close();
		}catch(IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
