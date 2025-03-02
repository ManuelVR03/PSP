package com.ejemplos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmpleadoDTO {

	private String nombre;
	private Float salario;
	private String nombreJefe;
}
