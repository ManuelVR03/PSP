package com.ejemplos.modelo;




import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
@jakarta.persistence.Entity
public class Categoria {

	@Id 
	private Long idcat;
	
	private String nombre;
	
}
