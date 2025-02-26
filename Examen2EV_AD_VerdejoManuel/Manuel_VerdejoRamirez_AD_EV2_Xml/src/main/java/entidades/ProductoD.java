package entidades;

import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "producto")
@XmlType(propOrder = { "nombre", "categoria", "marca" })
public class ProductoD {

	private String idref;
	private String nombre;
	private String categoria;
	private String marca;

	public ProductoD() {
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
		ProductoD other = (ProductoD) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "ProductoD [idref=" + idref + ", nombre=" + nombre + ", categoria=" + categoria + ", marca=" + marca
				+ "]";
	}
	
	
	
}
