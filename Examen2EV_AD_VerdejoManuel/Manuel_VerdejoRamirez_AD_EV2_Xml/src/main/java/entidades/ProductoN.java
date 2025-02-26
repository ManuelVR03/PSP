package entidades;

import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="producto")
@XmlType(propOrder = {"nombre", "proveedor", "importancia", "pais"})
public class ProductoN {

	private String idref;
	private String nombre;
	private String proveedor;
	private String importancia;
	private String pais;
	
	public ProductoN() {
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute
	public String getIdref() {
		return idref;
	}

	public void setIdref(String idref) {
		this.idref = idref;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoN other = (ProductoN) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "ProductoN [idref=" + idref + ", nombre=" + nombre + ", proveedor=" + proveedor + ", importancia="
				+ importancia + ", pais=" + pais + "]";
	}
	
	
	
	
	
	
	
}
