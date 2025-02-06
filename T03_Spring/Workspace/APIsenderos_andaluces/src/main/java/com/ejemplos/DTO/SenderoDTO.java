package com.ejemplos.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SenderoDTO {

	private String nombre;
	private Integer distancia;
	private String municipioNombre;
}
