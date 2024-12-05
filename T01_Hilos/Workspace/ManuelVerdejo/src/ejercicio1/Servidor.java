package ejercicio1;

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

public class Servidor {

	public static void main(String[] args) {
		ServerSocket servidor;
		Socket socket;
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		String cadena, usuario, edad, envio;
		char ini;
		FileWriter fichero;
		BufferedWriter escribir;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			socket = servidor.accept();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			fichero = new FileWriter("Usuarios.txt", true);
			escribir = new BufferedWriter(fichero);
			
			while(!(cadena = in.readUTF()).equalsIgnoreCase("fin")) {
				cadena = cadena.replaceAll(" ", "");
				usuario = cadena.substring(0,cadena.indexOf(","));
				edad = cadena.substring(cadena.indexOf(",")+1, cadena.length());
				ini = usuario.charAt(0);
				if(ini >= 'a' && ini <= 'z' || ini >= 'A' && ini <= 'Z') {
					envio = "Usuario incorrecto";		
				}else {
					envio = "Datos correctos: guardados en el fichero";
					escribir.write("Usuario: " + usuario + ", Edad: " + edad + "\n");
				}
				out.writeUTF(envio);
			}
			
			escribir.close();
			fichero.close();
			socket.close();

		} catch (IOException e) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
