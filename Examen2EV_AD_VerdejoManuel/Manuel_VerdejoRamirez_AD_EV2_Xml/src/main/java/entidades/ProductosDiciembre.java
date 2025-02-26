package entidades;

import java.util.Set;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="productos")
public class ProductosDiciembre {

	private Set<ProductoD> productosD;

	public ProductosDiciembre() {
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name="producto")
	public Set<ProductoD> getProductosD() {
		return productosD;
	}

	public void setProductosD(Set<ProductoD> productosD) {
		this.productosD = productosD;
	}

	@Override
	public String toString() {
		return "ProductosDiciembre [productosD=" + productosD + "]";
	}
	
	
	
	
}
