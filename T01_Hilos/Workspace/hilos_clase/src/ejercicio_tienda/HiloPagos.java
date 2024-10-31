package ejercicio_tienda;

import java.util.List;

public class HiloPagos extends Thread{
	
	private Tienda miTienda;
	
	public HiloPagos() {
		miTienda = new Tienda();
	}
	
	public void run() {
		List<Cliente> clientes = miTienda.getCarroClientes();
		List<Producto> productos = miTienda.getProductos();
		boolean compraRealizada = true;
		for(Cliente cliente: clientes) {
			List<ItemProducto> items = cliente.getFactura();
			for(ItemProducto item: items) {
				for(Producto p: productos) {
					if(item.getCantidad() <= p.getStock()) {
						p.setStock(p.getStock()-item.getCantidad());
					}else {
						System.out.println("El cliente: " + cliente.getNombre() + " no puede comprar el producto: " + p.getNombreProd() + " por falta de stock.");
						compraRealizada = false;
					}
				}
			}
			if(compraRealizada) {
				System.out.println("El cliente " + cliente.getNombre() + " ha podido realizar su compra con éxito");
			}else {
				System.out.println("El cliente " + cliente.getNombre() + " no ha podido realizar su compra por problemas de stock");
			}
		}
	}

}
