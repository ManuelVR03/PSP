package ejercicio_tienda;

import java.util.List;

public class Cliente {
	private Integer codigo;
	private String nombre;
	private List<ItemProducto> factura;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer codigo, String nombre, List<ItemProducto> factura) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.factura = factura;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ItemProducto> getFactura() {
		return factura;
	}

	public void setFactura(List<ItemProducto> factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", factura=" + factura + "]";
	}

}
