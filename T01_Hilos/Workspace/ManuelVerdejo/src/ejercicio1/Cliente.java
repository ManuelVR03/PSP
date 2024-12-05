package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		Scanner teclado = new Scanner(System.in);
		String envio, respuesta;
		
		try {
			socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			do {
				System.out.println("Introduce nombre de usuario y la edad ($Manuelvr03, 21): ");
				envio = teclado.nextLine();
				out.writeUTF(envio);
				if(!(respuesta = in.readUTF()).equalsIgnoreCase("Datos correctos: guardados en el fichero"))
					System.out.println("Errores encontrados: " + respuesta);
				else
					System.out.println(respuesta);
			}while(!envio.equalsIgnoreCase("fin"));
			
			socket.close();
			teclado.close();
		}catch(IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
