package com.ejemplos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.DTO.CreateEmpleadoDTO;
import com.ejemplos.DTO.EmpleadoDTO;
import com.ejemplos.DTO.EmpleadoDTOConverter;
import com.ejemplos.modelo.Empleado;
import com.ejemplos.modelo.EmpleadoRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmpleadoController {

	@Autowired
	private final EmpleadoRepositorio empleadoRepositorio;
	
	@Autowired
	private final EmpleadoDTOConverter empleadoDTOConverter;
	
	@GetMapping("/empleado")
	public ResponseEntity<?> obtenerTodos() {
		List<Empleado> result = empleadoRepositorio.findAll();
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<EmpleadoDTO> dtoList = result.stream().map(empleadoDTOConverter::convertirADTO).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	
	@GetMapping("/empleado/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		Empleado empleado = empleadoRepositorio.findById(id).orElse(null);
		if (empleado == null)
			return ResponseEntity.notFound().build();
		else 
			return ResponseEntity.ok(empleadoDTOConverter.convertirADTO(empleado));
	}
	
	@PostMapping("/empleado")
	public ResponseEntity<?> nuevoEmpleado(@RequestBody CreateEmpleadoDTO nuevo) {
		Empleado e = empleadoDTOConverter.convertirAEmpl(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoRepositorio.save(e));
	}
	
	@PutMapping("/empleado/{id}")
	public ResponseEntity<?> editarEmpleado(@RequestBody CreateEmpleadoDTO editar, @PathVariable Long id) {
		if(empleadoRepositorio.existsById(id)) {
			Empleado e = empleadoDTOConverter.convertirAEmpl(editar);
			e.setId(id);
			if(editar.getSalario()==0.0)
				e.setSalario(empleadoRepositorio.findById(id).get().getSalario());
			if(editar.getNombre()==null)
				e.setNombre(empleadoRepositorio.findById(id).get().getNombre());
			if(editar.getEmail()==null)
				e.setEmail(empleadoRepositorio.findById(id).get().getEmail());
			return ResponseEntity.ok(empleadoRepositorio.save(e));
		}else
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/empleado/{id}")
	public ResponseEntity<?> borrarEmpleado(@PathVariable Long id) {
		if(empleadoRepositorio.existsById(id)) {
			Empleado result = empleadoRepositorio.findById(id).get();
			empleadoRepositorio.delete(result);
			return ResponseEntity.noContent().build();
		}else
			return ResponseEntity.notFound().build();
	}
}
