package ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	/*
	 * Un cliente envía números enteros positivos al servidor hasta que el cliente
	 * envíe un número negativo. El servidor lee número a número y responde OK
	 * cuando recibe cada número. El servidor crea un fichero de texto
	 * (ejercicio3.txt) donde guarda cada número en líneas de 6 números. Si existe
	 * el fichero, no se sobreescribe sino que la información se añade al final. Hay
	 * que usar Sockets TCP.
	 */

	public static void main(String[] args) {
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		Scanner teclado = new Scanner(System.in);
		int num;
		String escuchar;
		
		try {
			socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			do {
				System.out.println("Introduce un número positivo: ");
				num = teclado.nextInt();
				out.writeInt(num);
				escuchar = in.readUTF();
				System.out.println("Servidor dice: " + escuchar);
			}while (num >= 0);
			
			socket.close();
			teclado.close();
		}catch(IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
