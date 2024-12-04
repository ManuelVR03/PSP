package tienda_lucia;

public class ItemProducto {
	
	private Integer codigoProducto;
	private Integer cantidad;
	private Double precio;
	
	public ItemProducto(Integer codigoProducto, Integer cantidad, Double precio) {
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
