package com.ejemplos.modelo;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sendero {

	@Id
	private String cod_sendero;
	private String nombre;
	private Integer distancia;
	private String dificultad;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cod_municipio")
	private Municipio municipio;
}
