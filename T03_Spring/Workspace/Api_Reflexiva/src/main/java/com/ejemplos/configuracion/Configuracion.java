package com.ejemplos.configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ejemplos.dto.EmpleadoDTO;
import com.ejemplos.modelo.Empleado;

@Configuration
public class Configuracion {

	@Bean
	public ModelMapper modelMapper() {
	    ModelMapper modelMapper = new ModelMapper();

	    modelMapper.typeMap(Empleado.class, EmpleadoDTO.class).addMappings(mapper -> {
	        mapper.map(src -> src.getJefe() != null ? src.getJefe().getNombre() : "Sin jefe", EmpleadoDTO::setNombreJefe);
	    });

	    return modelMapper;
	}

}

