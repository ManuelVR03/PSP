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
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.modelo.Producto;
import com.ejemplos.modelo.ProductoRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductoController {

	private final ProductoRepositorio productoRepositorio;
	
	/**
	 * Obtenemos todos los productos
	 * @return 404 si no hay productos, 200 y lista de productos si hay uno o mas
	 */
	@GetMapping("/producto")
	public ResponseEntity<?> obtenerTodos() {
		List<Producto> result = productoRepositorio.findAll();
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(result);
	}
	
	/* @PathVariable: permite inyectar un fragmento de la URL
	 * en una variable, es decir, pasa el valor del id
	 * de la URL al método como parámetro donde esté @PathVariable
	 */
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		Producto producto = productoRepositorio.findById(id).orElse(null);
		if (producto == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(producto);
	}
	
	/**
	 * Insertar un nuevo producto
	 */
	
	/*
	 * @RequestBody Permite inyectar el cuerpo de la petición de un objeto,
	 * guardo en nuevo lo que venga en el body de la petición
	 */
	@PostMapping("/producto")
	public ResponseEntity<?> nuevoProducto(@RequestBody Producto nuevo) {
		Producto saved = productoRepositorio.save(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	/**
	 * Actualiza un producto
	 */
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> editarProducto(@RequestBody Producto editar, @PathVariable Long id) {
		if(productoRepositorio.existsById(id)) {
			editar.setId(id);
			return ResponseEntity.ok(productoRepositorio.save(editar));
		}else
			return ResponseEntity.notFound().build();
	}
	
	/**
	 * Eliminar un producto
	 */
	
	/*
	@DeleteMapping("/producto/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		if(productoRepositorio.existsById(id))
			productoRepositorio.deleteById(id);
	}
	*/
	
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
		if(productoRepositorio.existsById(id)) {
			Producto result = productoRepositorio.findById(id).get();
			productoRepositorio.delete(result);
			return ResponseEntity.noContent().build();
		}else
			return ResponseEntity.notFound().build();
	}
}
