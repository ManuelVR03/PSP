package ejercicio_tienda_MJ;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
	private List<Cliente> carroClientes; // carrito de compra de clientes
	private List<Producto> productos; // lista de productos de la tienda

	//constructor ejemplo
	public Tienda() {
		this.carroClientes = new ArrayList<Cliente>();
		List<ItemProducto> carro1 = new ArrayList<ItemProducto>();
		carro1.add(new ItemProducto(1, 2, 12.2));
		carro1.add(new ItemProducto(3, 3, 23.0));
		carro1.add(new ItemProducto(2, 4, 5.95));
		Cliente cli1 = new Cliente(1, "juan", carro1);
		List<ItemProducto> carro2 = new ArrayList<ItemProducto>();
		carro2.add(new ItemProducto(1, 4, 12.2));
		carro2.add(new ItemProducto(2, 3, 23.0));
		Cliente cli2 = new Cliente(2, "antonia", carro2);
		Cliente cli3 = new Cliente(3, "lola", carro1);
		this.carroClientes.add(cli1);
		this.carroClientes.add(cli2);
		this.carroClientes.add(cli3);
		this.productos = new ArrayList<Producto>();
		this.productos.add(new Producto(1, "cortadora", 12, 12.2));
		this.productos.add(new Producto(2, "compostadora", 5, 122.2));
		this.productos.add(new Producto(3, "maceta", 14, 6.0));
		this.productos.add(new Producto(4, "jardinera", 5, 80.2));
	}

	public List<Cliente> getCarroClientes() {
		return carroClientes;
	}

	public void setCarroClientes(List<Cliente> carroClientes) {
		this.carroClientes = carroClientes;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Tienda [carroClientes=" + carroClientes + ", productos=" + productos + "]";
	}
	
	
}