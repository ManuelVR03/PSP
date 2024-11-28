package ejercicio3;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Un cliente envía números enteros positivos al servidor hasta que el cliente envíe un número
 * negativo. El servidor lee número a número y responde OK cuando recibe cada número. El servidor
 * crea un fichero de texto (ejercicio3.txt) donde guarda cada número en líneas de 6 números. Si
 * existe el fichero, no se sobreescribe sino que la información se añade al final. Hay que usar Sockets
 * TCP.
 */

public class Servidor {

	public static void main(String[] args) {
		ServerSocket servidor;
		Socket socket;
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		int num, salto = 0;
		String linea = "";
		FileWriter fichero;
		BufferedWriter escribir;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			socket = servidor.accept();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			fichero = new FileWriter("ejercicio3.txt", true);
			escribir = new BufferedWriter(fichero);

			num = in.readInt();
			while (num >= 0) {
				out.writeUTF("OK");
				linea += num + " ";
				salto++;
				if (salto == 6) {
					escribir.write(linea + "\n");
					linea = "";
					salto = 0;
				}
				num = in.readInt();
			}
			if (!linea.isEmpty()) {
                escribir.write(linea + "\n");
            }

			escribir.close();
			fichero.close();
			socket.close();

		} catch (IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
