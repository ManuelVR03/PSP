package tienda_lucia;

public class Producto {
	
	private Integer codigoProducto;
	private String nombreProd;
	private Integer stock;
	private Double precio;
	
	public Producto(Integer codigoProducto, String nombreProd, Integer stock, Double precio) {
		this.codigoProducto = codigoProducto;
		this.nombreProd = nombreProd;
		this.stock = stock;
		this.precio = precio;
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}