package com.ejemplos.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//al lanzar la excepción será un código 404 el que reciba el cliente 
//y no el 500 como sería en un principio
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ProductoNotFoundException(Long id) {
		super("No se puede encontrar el producto con la ID: " + id);
	}
	
	
}
