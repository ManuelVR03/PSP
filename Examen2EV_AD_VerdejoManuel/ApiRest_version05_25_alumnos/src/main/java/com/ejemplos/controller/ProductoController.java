package com.ejemplos.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.DTO.ProductoDTO;
import com.ejemplos.DTO.ProductoDTOConverter;
import com.ejemplos.excepciones.ApiError;
import com.ejemplos.excepciones.ProductoNotFoundException;
import com.ejemplos.modelo.Producto;
import com.ejemplos.modelo.ProductoRepositorio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ejemplos.DTO.CreateProductoDTO;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor  
public class ProductoController {
	@Autowired
	private   ProductoRepositorio productoRepositorio; 
	
	@Autowired
	private ProductoDTOConverter productoDTOConverter;
	
	
	/********************************************************************************************/
	
	
	@GetMapping("/producto")
	public ResponseEntity<?> obtenerTodos() {
		List<Producto> result = productoRepositorio.findAll();

		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {

			List<ProductoDTO> dtoList = result.stream().map(productoDTOConverter::convertirADto)
					.collect(Collectors.toList());

			return ResponseEntity.ok(dtoList);
		}

	}


	/********************************************************************************************/
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
			Producto result = productoRepositorio.findById(id).orElse(null);
			if (result == null)
				throw new ProductoNotFoundException(id);
			
			return ResponseEntity.ok(result);
	}

	/********************************************************************************************/
	
	@PostMapping("/producto")
	public ResponseEntity<?> nuevoProducto(@RequestBody CreateProductoDTO nuevo) {
		Producto n= productoDTOConverter.convertirAProd(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoRepositorio.save(n));
	}
	
	
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> editarProducto(@RequestBody CreateProductoDTO editar, @PathVariable Long id) {
	
		if (!productoRepositorio.existsById(id)) throw new ProductoNotFoundException(id);
	
		Producto n= productoDTOConverter.convertirAProd(editar);
		n.setId(id);
		//si en el objeto editar no mandamos ciertos campos, debemos mantener lo que el objeto tiene
		//guardado en la BD
		if (editar.getCategoriaIdcat()==null)
			n.setCategoria(productoRepositorio.findById(id).get().getCategoria());
		if (editar.getNombre()==null)
			n.setNombre(productoRepositorio.findById(id).get().getNombre());
		if (editar.getPrecio()==0.0)
			n.setPrecio(productoRepositorio.findById(id).get().getPrecio());
		return ResponseEntity.ok(productoRepositorio.save(n));
	
	}
	
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
		Producto result = productoRepositorio.findById(id).orElse(null);
		if (result == null)
			 throw new ProductoNotFoundException(id);
		
		productoRepositorio.delete(result);
		return ResponseEntity.noContent().build();
		
	}

	//cuando se produzca un error de este tipo ejecuta este método
		@ExceptionHandler(ProductoNotFoundException.class)
		public ResponseEntity<ApiError> handleProductoNoEncontrado(ProductoNotFoundException ex) {
			ApiError apiError = new ApiError();
			apiError.setEstado(HttpStatus.NOT_FOUND);
			apiError.setFecha(LocalDateTime.now());
			apiError.setMensaje(ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
		}
		
		@ExceptionHandler(JsonProcessingException.class)
		public ResponseEntity<ApiError> handleJsonMappingException(JsonProcessingException ex) {
			ApiError apiError = new ApiError();
			apiError.setEstado(HttpStatus.BAD_REQUEST);
			apiError.setFecha(LocalDateTime.now());
			apiError.setMensaje(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
		}
		
}
