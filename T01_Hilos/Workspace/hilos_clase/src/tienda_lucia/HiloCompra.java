package tienda_lucia;

import java.util.ArrayList;
import java.util.List;

public class HiloCompra extends Thread{

	public Tienda tienda;
	public List<Cliente> clientes;
	public List<ItemProducto> itemsCliente;
	public List<Producto> productos;
	private boolean compra;
	
	public HiloCompra(Tienda tienda) {
		this.tienda = tienda;
		this.clientes = tienda.getCarroClientes();
		this.productos = tienda.getProductos();
		this.itemsCliente = new ArrayList<>();
		this.compra = false;
	}
	
	@Override
	public void run() {
		for (Cliente c: clientes) {
			compra = true;
			itemsCliente = c.getFactura();
			for(ItemProducto i: itemsCliente) {
				for(Producto p: productos) {
					if(i.getCodigoProducto() == p.getCodigoProducto() && i.getCantidad() <= p.getStock()) {
						p.setStock(p.getStock()-i.getCantidad());
						System.out.println("El cliente " + c.getNombre() + " ha realizado la compra de " + p.getNombreProd());
					}else if(i.getCodigoProducto() == p.getCodigoProducto() && i.getCantidad() > p.getStock()){
						System.out.println("El cliente " + c.getNombre() + " no puede comprar " + p.getNombreProd());
						compra = false;
					}
				}
			}
			if(compra)
				System.out.println("Compra realizada al completo por " + c.getNombre());
			else
				System.out.println(c.getNombre() + " no pudo realizar su compra");
		}
	}
}
