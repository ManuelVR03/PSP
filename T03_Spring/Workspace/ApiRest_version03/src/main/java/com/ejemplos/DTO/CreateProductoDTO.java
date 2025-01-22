package com.ejemplos.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateProductoDTO {

	private String nombre;
	private float precio;
	private Long categoriaId;
	
}
