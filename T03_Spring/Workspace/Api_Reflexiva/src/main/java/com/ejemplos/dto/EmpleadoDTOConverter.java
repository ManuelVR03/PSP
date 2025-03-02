package com.ejemplos.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.modelo.Empleado;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpleadoDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public EmpleadoDTO convertirADto(Empleado empleado) {
		return modelMapper.map(empleado, EmpleadoDTO.class);
	}
	
	public Empleado convertirAEmpl(CreateEmpleadoDTO createEmpleadoDTO) {
		return modelMapper.map(createEmpleadoDTO, Empleado.class);
	}
}
