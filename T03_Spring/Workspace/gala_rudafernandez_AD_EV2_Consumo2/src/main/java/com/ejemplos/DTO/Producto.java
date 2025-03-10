package com.ejemplos.DTO;

import lombok.Data;

@Data
public class Producto {
	
	private Long id;
	
	private String nombre;
	
	private float precio;
	
	private Categoria categoria;
}
