package com.ejemplos.modelo;

import java.time.LocalDate;
import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	@Temporal(TemporalType.DATE) 
	private Date fecha_creacion;
	//private LocalDate fecha_creacion;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cod_municipio")
	private Municipio municipio;
}
