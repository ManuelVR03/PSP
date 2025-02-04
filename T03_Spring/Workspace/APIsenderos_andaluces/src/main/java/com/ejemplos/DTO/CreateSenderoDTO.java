package com.ejemplos.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CreateSenderoDTO {

	private String nombre;
	private Integer distancia;
	private String dificultad;
	private String municipioCod_municipio;
}
