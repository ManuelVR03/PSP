package ejercicio_02_TCP_Mensajes_MJ;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejercicio 02:
 * Una aplicación cliente envía mensajes a una
 * aplicación servidor y el servidor contesta.
 */


public class Cliente02MJ {

    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        final int PUERTO = 5000;
        final String HOST = "127.0.0.1";
        DataInputStream in;
        DataOutputStream out;
        Socket socket = null;

        try {
        	String op = null;
        	int i = 1;
        	Scanner scanner = null;
        	scanner = new Scanner(System.in);
        	do {
        		socket = new Socket(HOST, PUERTO);
        		in = new DataInputStream(socket.getInputStream());
        		out = new DataOutputStream(socket.getOutputStream());
        		System.out.println(ANSI_BLUE + "Escribe un mensaje al servidor: ");
        		out.writeUTF(ANSI_BLUE + "llega mensaje desde el cliente! " + i++ + " "+ scanner.next());
        		System.out.println(in.readUTF());
        		System.out.println(ANSI_BLUE+"Desea mandar otro mensaje Si(s)/No(n)");
        		op=scanner.next();
        		out.close();
        		in.close();
        		socket.close();
        	}while(op.equals("s"));
        	scanner.close();
        	System.out.println("Cliente desconectado");
        } catch (IOException e) {
            Logger.getLogger(Cliente02MJ.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}