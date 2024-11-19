package ejercicio4_sockets_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 4.- Implementar un servidor utilizando tecnología Sockets JAVA UDP que
 * permita leer un número y devuelva al cliente la serie de los 10 números
 * siguientes. Implementar también el cliente.
 */

public class Servidor {

	public static void main(String[] args) {

		final int PUERTO = 5000;
		byte[] buffer = new byte[1024];

		try {
			System.out.println("Iniciado el servidor UDP");
			DatagramSocket socketUDP = new DatagramSocket(PUERTO);
			DatagramPacket peticion;
			DatagramPacket respuesta;
			String mensaje;
			int puertoCliente;
			InetAddress direccion;
			int numeroCliente;
			int numeroEnvio;
			while (true) {
				peticion = new DatagramPacket(buffer, buffer.length);
				socketUDP.receive(peticion);
				System.out.println("Recibo la informacion del cliente");
				mensaje = new String(peticion.getData(), 0, peticion.getLength());
				numeroCliente = Integer.parseInt(mensaje);
				puertoCliente = peticion.getPort();
				direccion = peticion.getAddress();
				System.out.println("Envío la información: ");
				for(int i = 1; i <= 10; i++) {
					numeroEnvio = numeroCliente + i;
					mensaje = String.valueOf(numeroEnvio);
					byte[] bufferEnvio = mensaje.getBytes();
					respuesta = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccion, puertoCliente);
					socketUDP.send(respuesta);
				}				
			}
		} catch (SocketException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
