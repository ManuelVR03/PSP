package com.ejemplos.controller;

import java.util.List;

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
	
	@GetMapping("/producto")
	public List<Producto> obtenerTodos() {
		return productoRepositorio.findAll();
	}
	
	/* @PathVariable: permite inyectar un fragmento de la URL
	 * en una variable, es decir, pasa el valor del id
	 * de la URL al método como parámetro donde esté @PathVariable
	 */
	@GetMapping("/producto/{id}")
	public Producto obtenerUno(@PathVariable Long id) {
		return productoRepositorio.findById(id).orElse(null);
	}
	
	/**
	 * Insertar un nuevo producto
	 */
	
	/*
	 * @RequestBody Permite inyectar el cuerpo de la petición de un objeto,
	 * guardo en nuevo lo que venga en el body de la petición
	 */
	@PostMapping("/producto")
	public Producto nuevoProducto(@RequestBody Producto nuevo) {
		return productoRepositorio.save(nuevo);
	}
	
	/**
	 * Actualiza un producto
	 */
	
	@PutMapping("/producto/{id}")
	public Producto editarProducto(@RequestBody Producto editar, @PathVariable Long id) {
		if(productoRepositorio.existsById(id)) {
			editar.setId(id);
			return productoRepositorio.save(editar);
		}else
			return null;
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
	public Producto borrarProducto(@PathVariable Long id) {
		if(productoRepositorio.existsById(id)) {
			Producto result = productoRepositorio.findById(id).get();
			productoRepositorio.deleteById(id);
			return result;
		}else
			return null;
	}
}
