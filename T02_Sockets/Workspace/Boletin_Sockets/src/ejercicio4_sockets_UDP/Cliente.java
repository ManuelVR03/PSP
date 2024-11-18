package ejercicio4_sockets_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		
		final int PUERTO_SERVIDOR = 5000;
		byte[] buffer = new byte[1024];
		InetAddress direccionServidor;
		DatagramSocket socketUDP;
		String mensaje;
		DatagramPacket pregunta;
		DatagramPacket peticion;
		Scanner teclado = new Scanner(System.in);
		try {
			direccionServidor = InetAddress.getByName("localhost");
			socketUDP = new DatagramSocket();
			System.out.println("Introduce un número");
			mensaje = teclado.nextLine();
			buffer = mensaje.getBytes("UTF-8");
			pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
			System.out.println("Envio el datagrama");
            socketUDP.send(pregunta);
            peticion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(peticion);
            System.out.println("Recibo la peticion");
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);
            socketUDP.close();
		} catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
