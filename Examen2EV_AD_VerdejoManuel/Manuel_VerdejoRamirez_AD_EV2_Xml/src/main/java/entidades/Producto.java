package entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ref")
	private String idRef;

	private String categoria;

	private String importacion;

	private String marca;

	private String nombre;

	private String pais;

	private String proveedor;

	public Producto() {
	}

	public String getIdRef() {
		return this.idRef;
	}

	public void setIdRef(String idRef) {
		this.idRef = idRef;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImportacion() {
		return this.importacion;
	}

	public void setImportacion(String importacion) {
		this.importacion = importacion;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [idRef=" + idRef + ", categoria=" + categoria + ", importacion=" + importacion + ", marca="
				+ marca + ", nombre=" + nombre + ", pais=" + pais + ", proveedor=" + proveedor + "]";
	}
	
	

}