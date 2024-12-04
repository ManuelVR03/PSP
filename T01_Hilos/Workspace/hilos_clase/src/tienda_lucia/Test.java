package tienda_lucia;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		Tienda mitienda = new Tienda();
		HiloCompra hilo = new HiloCompra(mitienda);
		hilo.start();

	}

}
