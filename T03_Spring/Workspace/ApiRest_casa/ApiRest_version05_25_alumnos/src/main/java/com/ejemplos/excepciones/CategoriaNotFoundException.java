package com.ejemplos.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//al lanzar la excepción será un código 404 el que reciba el cliente 
//y no el 500 como sería en un principio
@ResponseStatus(HttpStatus.NOT_FOUND) //cuando ocurra un notfound la va a lanzar
public class CategoriaNotFoundException extends RuntimeException {
	//runitmeexcepton: salta la excepcion pero no obliga  a hacer throws
	private static final long serialVersionUID = 1L;

	public CategoriaNotFoundException(Long id) {
		super("No se puede encontrar la categoria con la ID: " + id);
	}
	
	
}
