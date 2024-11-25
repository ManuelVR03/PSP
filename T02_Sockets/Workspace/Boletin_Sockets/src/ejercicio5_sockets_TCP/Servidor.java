package ejercicio5_sockets_TCP;

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
		int num1, num2;
		String op;
		float resultado = 0f;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			socket = servidor.accept();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			while(true) {
                num1 = in.readInt();
                num2 = in.readInt();
                op = in.readUTF();
                if(op.equalsIgnoreCase("salir")) break;
                switch(op) {
                case "+":
                	resultado = num1 + num2;
                	break;
                case "-":
                	resultado = num1 - num2;
                	break;
                case "*":
                	resultado = num1 * num2;
                	break;
                case "/":
                	resultado = num1 / num2;
                	break;
                	
                }
                out.writeFloat(resultado);
            }

			socket.close();
			servidor.close();

		} catch (IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
