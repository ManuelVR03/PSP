package com.ejemplos.DTO;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SenderoDTO {

	private String nombre;
	private Integer distancia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	private Date fecha_creacion;
	//private LocalDate fecha_creacion;
	private String municipioNombre;
}
