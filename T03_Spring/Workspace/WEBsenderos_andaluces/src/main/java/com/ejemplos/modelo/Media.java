package com.ejemplos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {
	
	@Id
	private String cod_sendero;
	private String nombre;
	private Integer distancia;
	private String dificultad;
	private String municipioNombre_municipio;
}
