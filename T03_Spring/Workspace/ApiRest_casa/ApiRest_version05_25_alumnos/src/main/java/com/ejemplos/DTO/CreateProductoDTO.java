package com.ejemplos.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CreateProductoDTO {
	
	private String nombre;
	private float precio;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date fecha_caducidad;
	private Long categoriaIdcat;
	
}
