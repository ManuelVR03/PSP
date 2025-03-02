package com.ejemplos.excepciones;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiError {
	private HttpStatus estado;
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss") //esto es una mascara para que me 
	//lo ponga en dia mes y año 
	private LocalDateTime fecha;
	private String mensaje;
	
}
