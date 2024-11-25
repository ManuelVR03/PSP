package ejercicio7_sockets_TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 7.- Implementar dos aplicaciones tal que una envíe el contenido de un fichero de
texto (el cliente) y la otra (el servidor) lea ese fichero de texto y lo muestre por
pantalla. Utiliza para ello sockets TCP. El servidor recibe cada línea del fichero e
indica n.º de línea y n.º de caracteres de cada línea.
 */

public class Cliente {

	public static void main(String[] args) {
		
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataInputStream in;
		DataOutputStream out;
		Socket socket;
		BufferedReader lector;
		String linea = "";
		String rutaArchivo = "/home/usuario/DAM/PSP/T02_Sockets/Workspace/Boletin_Sockets/src/ejercicio7_sockets_TCP/Fichero.txt"; 

		try {
			socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("Cliente iniciado");
            try {
            	lector = new BufferedReader(new FileReader(rutaArchivo));
            	linea = lector.readLine();
                while (linea != null) {
                    out.writeUTF(linea);
                    linea = lector.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: El archivo no se encontró");
            }			
			System.out.println("Cortamos conexión");
			socket.close();
		}catch(IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
