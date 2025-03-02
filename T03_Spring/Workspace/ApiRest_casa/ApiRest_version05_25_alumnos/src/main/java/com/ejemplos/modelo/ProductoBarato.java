package com.ejemplos.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor 
@Entity
public class ProductoBarato implements Serializable {
	@Id
	private Long id;
	
	private String nombre;
	
	private float precio;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date fecha_caducidad;
	
	private String categoriaNombre;
}
