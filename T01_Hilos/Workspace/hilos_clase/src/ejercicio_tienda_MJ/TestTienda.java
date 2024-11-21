package ejercicio_tienda_MJ;

public class TestTienda {

	public static void main(String[] args) {
		Tienda tienda = new Tienda();
		synchronized (tienda) {
			for (Cliente cliente: tienda.getCarroClientes()) {
			FormalizarPago pago = new FormalizarPago(tienda, cliente);
			}	
		}

	}

}
