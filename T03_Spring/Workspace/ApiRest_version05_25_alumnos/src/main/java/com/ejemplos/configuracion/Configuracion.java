package com.ejemplos.configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Configuracion {
	
	@Bean
    ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
