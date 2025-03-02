package com.ejemplos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.dto.CreateEmpleadoDTO;
import com.ejemplos.dto.EmpleadoDTO;
import com.ejemplos.dto.EmpleadoDTOConverter;
import com.ejemplos.modelo.Empleado;
import com.ejemplos.modelo.EmpleadoRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepositorio empleadoRepository;
	
	@Autowired
	private EmpleadoDTOConverter empleadoDTOConverter;
	
	@GetMapping("/empleado")
	public ResponseEntity<?> obtenerTodos() {
		List<Empleado> result = empleadoRepository.findAll();
		if(result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<EmpleadoDTO> dtoList = result.stream().map(empleadoDTOConverter::convertirADto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	
	@PostMapping("/empleado")
	public ResponseEntity<?> nuevoEmpleado(@RequestBody CreateEmpleadoDTO nuevo){
		Empleado e = empleadoDTOConverter.convertirAEmpl(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoRepository.save(e));
	}

}
