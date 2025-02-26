package com.ejemplos.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CreateProductoDTO {
	
	private String nombre;
	private float precio;
	private Long categoriaIdcat;
	
}
