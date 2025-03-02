package com.ejemplos.DTO;

import java.util.Date;

import com.ejemplos.modelo.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {
	
	private Long id;
	private String nombre;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date fecha_caducidad;
	private float precio;
	//private Categoria categoria;
	private String categoriaNombre;
}
