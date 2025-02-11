package com.ejemplos.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MunicipioNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MunicipioNotFoundException(String id) {
		super("No se puede encontrar el municipio con el código: " + id);
	}
}
