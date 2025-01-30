package com.ejemplos.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEmpleadoDTO {
	private String nombre;
	private String email;
	private double salario;
	private Long departamento_id;
	private Long proyecto_id;
}
