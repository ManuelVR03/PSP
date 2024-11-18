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

public class Cliente {

	public static void main(String[] args) {
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataOutputStream out;
		Socket socket;
		Scanner teclado;
		int num1, num2;
		String op;
		
		try {
			socket = new Socket(HOST, PUERTO);
			out = new DataOutputStream(socket.getOutputStream());
			
			do {
				teclado = new Scanner(System.in);
                System.out.println("Introduce un número: ");
                num1 = teclado.nextInt();
                out.writeInt(num1);
                System.out.println("Introduce otro número: ");
                num2 = teclado.nextInt();
                out.writeInt(num2);
                System.out.println("Introduce una operación (+, -, *, /): ");
                teclado = new Scanner(System.in);
                op = teclado.nextLine();
                out.writeUTF(op);

            } while (num2 != 0 && !op.equals("/"));
			
			socket.close();
			teclado.close();
		}catch(IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
