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

import com.ejemplos.DTO.CreateProductoDTO;
import com.ejemplos.DTO.ProductoDTO;
import com.ejemplos.DTO.ProductoDTOConverter;
import com.ejemplos.modelo.Producto;
import com.ejemplos.modelo.ProductoRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductoController {

	@Autowired
	private final ProductoRepositorio productoRepositorio;
	
	@Autowired
	private final ProductoDTOConverter productoDTOConverter;
	
	/**
	 * Obtenemos todos los productos
	 * @return 404 si no hay productos, 200 y lista de productos si hay uno o mas
	 */
	
	@GetMapping("/producto")
	public ResponseEntity<?> obtenerTodos() {
		List<Producto> result = productoRepositorio.findAll();
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<ProductoDTO> dtoList = result.stream().map(productoDTOConverter::convertirADto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		Producto producto = productoRepositorio.findById(id).orElse(null);
		if (producto == null)
			return ResponseEntity.notFound().build();
		else 
			return ResponseEntity.ok(productoDTOConverter.convertirADto(producto));
	}
	
	/**
	 * Insertar un nuevo producto
	 */
	
	@PostMapping("/producto")
	public ResponseEntity<?> nuevoProducto(@RequestBody CreateProductoDTO nuevo) {
		Producto n = productoDTOConverter.convertirAProd(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoRepositorio.save(n));
	}
	
	/**
	 * Actualiza un producto
	 */
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> editarProducto(@RequestBody CreateProductoDTO editar, @PathVariable Long id) {
		if(productoRepositorio.existsById(id)) {
			Producto n = productoDTOConverter.convertirAProd(editar);
			n.setId(id);
			if(editar.getCategoriaId()==null)
				n.setCategoria(productoRepositorio.findById(id).get().getCategoria());
			if(editar.getNombre()==null)
				n.setNombre(productoRepositorio.findById(id).get().getNombre());
			if(editar.getPrecio()==0.0)
				n.setPrecio(productoRepositorio.findById(id).get().getPrecio());
			return ResponseEntity.ok(productoRepositorio.save(n));
		}else
			return ResponseEntity.notFound().build();
	}
	
	/**
	 * Eliminar un producto
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
