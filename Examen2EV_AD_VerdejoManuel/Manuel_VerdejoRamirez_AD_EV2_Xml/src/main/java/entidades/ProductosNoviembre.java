package entidades;

import java.util.Set;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="productos")
public class ProductosNoviembre {

	private Set<ProductoN> productosN;

	public ProductosNoviembre() {
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name="producto")
	public Set<ProductoN> getProductosN() {
		return productosN;
	}

	public void setProductosN(Set<ProductoN> productosN) {
		this.productosN = productosN;
	}

	@Override
	public String toString() {
		return "ProductosNoviembre [productosN=" + productosN + "]";
	}
	
	

	
	
	


	
}
