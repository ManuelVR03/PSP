package com.ejemplos.modelo;




import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Categoria {

	@Id 
	private Long idcat;
	
	private String nombre;
	
	@OneToMany(mappedBy = "categoria")
	@JsonManagedReference
	private List<Producto> productos;

}
