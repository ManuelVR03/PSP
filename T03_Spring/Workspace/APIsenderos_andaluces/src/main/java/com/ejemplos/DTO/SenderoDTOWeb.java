package com.ejemplos.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SenderoDTOWeb {
	private String cod_sendero;
	private String nombre;
	private Integer distancia;
	private String dificultad;
	private String municipioNombre_municipio;
}
