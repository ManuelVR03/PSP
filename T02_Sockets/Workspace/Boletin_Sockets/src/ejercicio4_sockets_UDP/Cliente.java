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
		byte[] buffer;
		InetAddress direccionServidor;
		DatagramSocket socketUDP;
		int num;
		String mensaje;
		DatagramPacket pregunta;
		DatagramPacket peticion;
		Scanner teclado = new Scanner(System.in);
		try {
			direccionServidor = InetAddress.getByName("localhost");
			socketUDP = new DatagramSocket();
			System.out.println("Introduce un número");
			num = teclado.nextInt();
			buffer = String.valueOf(num).getBytes("UTF-8");
			pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
			System.out.println("Envio el datagrama");
            socketUDP.send(pregunta);
            System.out.println("Recibo la peticion");
            System.out.println("Los 10 siguientes números a " + num + " son:");
            for(int i = 0; i < 10; i++) {
            	buffer = new byte[1024];
            	peticion = new DatagramPacket(buffer, buffer.length);
            	socketUDP.receive(peticion);
            	mensaje = new String(peticion.getData(), 0, peticion.getLength());
            	System.out.println(mensaje);
            }
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
