package com.ejemplos.controller;

import java.util.List;

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

import com.ejemplos.modelo.Pais;
import com.ejemplos.modelo.PaisRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PaisController {

	@Autowired
	private final PaisRepositorio paisRepositorio;
	
	/**
	 * 	Métodos para CRUD
	 */
	
	@GetMapping("/pais")
	public ResponseEntity<?> obtenerTodos(){
		List<Pais> result = paisRepositorio.findAll();
		if(result.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(result);
	}
	
	@GetMapping("/pais/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Integer id) {
		Pais pais = paisRepositorio.findById(id).orElse(null);
		if (pais == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(pais);
	}
	
	@PostMapping("/pais")
	public ResponseEntity<?> nuevoPais(@RequestBody Pais nuevo) {
		Pais saved = paisRepositorio.save(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@PutMapping("/pais/{id}")
	public ResponseEntity<?> editarProducto(@RequestBody Pais editar, @PathVariable Integer id) {
		if(paisRepositorio.existsById(id)) {
			editar.setId(id);
			return ResponseEntity.ok(paisRepositorio.save(editar));
		}else
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/pais/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable Integer id) {
		if(paisRepositorio.existsById(id)) {
			Pais result = paisRepositorio.findById(id).get();
			paisRepositorio.delete(result);
			return ResponseEntity.noContent().build();
		}else
			return ResponseEntity.notFound().build();
	}
	
}
