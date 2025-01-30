package com.ejemplos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.modelo.Usuario;
import com.ejemplos.modelo.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apirestUsuario")
public class UsuarioController {

	private final UsuarioRepositorio usuarioRepositorio;
	

	@GetMapping("/usuario")
	public ResponseEntity<?> obtenerTodos() {
		List<Usuario> result = usuarioRepositorio.findAll();
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(result);
	}
	

	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		Usuario usuario = usuarioRepositorio.findById(id).orElse(null);
		if (usuario == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<?> nuevoUsuario(@RequestBody Usuario nuevo) {
		Usuario saved = usuarioRepositorio.save(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> editarUsuario(@RequestBody Usuario editar, @PathVariable Long id) {
		if(usuarioRepositorio.existsById(id)) {
			editar.setId(id);
			return ResponseEntity.ok(usuarioRepositorio.save(editar));
		}else
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> borrarUsuario(@PathVariable Long id) {
		if(usuarioRepositorio.existsById(id)) {
			Usuario result = usuarioRepositorio.findById(id).get();
			usuarioRepositorio.delete(result);
			return ResponseEntity.noContent().build();
		}else
			return ResponseEntity.notFound().build();
	}
}
