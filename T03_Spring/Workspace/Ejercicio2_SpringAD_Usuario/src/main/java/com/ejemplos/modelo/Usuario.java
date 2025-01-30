package com.ejemplos.modelo;

import lombok.Data;

@Data
public class Usuario {
	private Long id;
	private String nombre;
	private String usuario;
	private String avatar;
	private String email;
}
