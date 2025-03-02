package com.ejemplos.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
import com.ejemplos.excepciones.CategoriaNotFoundException;
import com.ejemplos.excepciones.ProductoNotFoundException;
import com.ejemplos.modelo.Categoria;
import com.ejemplos.modelo.CategoriaRepositorio;
import com.ejemplos.modelo.Producto;
import com.ejemplos.modelo.ProductoBarato;
import com.ejemplos.modelo.ProductoBaratoRepositorio;
import com.ejemplos.modelo.ProductoRepositorio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ejemplos.DTO.CreateProductoDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductoController {
	@Autowired
	private ProductoRepositorio productoRepositorio;

	@Autowired
	private ProductoBaratoRepositorio productoBaratoRepositorio;
	@Autowired
	private ProductoDTOConverter productoDTOConverter;

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

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

	@GetMapping("/productosBaratos")
	public ResponseEntity<?> obtenerBaratos() {
		List<ProductoBarato> result = productoBaratoRepositorio.findAll();
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {

			return ResponseEntity.ok(result);
		}
	}

	@GetMapping("/listado")
	public String obtenerListado() {
		String cadena = "";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("ProductosBaratos.obj");
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);

			// cargar el fichero
			while (bis.available() > 0) {
				ProductoBarato p = (ProductoBarato) ois.readObject();
				cadena += p.toString() + "\n";
			}

			ois.close();
			bis.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.getMessage();
		}
		return cadena;

		/*
		 * leer fichero de texto: FileReader fr; BufferedReader br; try { fr = new
		 * FileReader("ProductosBaratos.txt"); br = new BufferedReader(fr); String
		 * cadena=""; while (br.ready()) { linea = br.readLine(); //contenido de la
		 * linea cadena+=linea } } catch (IOException e) { e.printStackTrace(); }
		 */

	}

	@GetMapping("/categoria/{id}")
	public ResponseEntity<?> obtenerUnoCategoria(@PathVariable Long id) {
		Categoria result = categoriaRepositorio.findById(id).orElse(null);
		if (result == null)
			throw new ProductoNotFoundException(id);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/categoria")
	public ResponseEntity<?> obtenerTodosCategoria() {
		List<Categoria> result = categoriaRepositorio.findAll();

		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}
	}

	/********************************************************************************************/

	@PostMapping("/producto")
	public ResponseEntity<?> nuevoProducto(@RequestBody CreateProductoDTO nuevo) {
		if (!categoriaRepositorio.existsById(nuevo.getCategoriaIdcat())) {
			throw new CategoriaNotFoundException(nuevo.getCategoriaIdcat());
		}
		Producto n = productoDTOConverter.convertirAProd(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoRepositorio.save(n));
	}

	@PostMapping("/importarProductos")
	public String importarProductos() {
		List<Producto> result = productoRepositorio.findAll();
		List<ProductoBarato> productosBaratos = new ArrayList<>();
		for (Producto prod : result) {
			if (prod.getPrecio() < 10.0) {
				long id = prod.getId();
				float precio = prod.getPrecio();
				String nombre = prod.getNombre();
				Date fecha = prod.getFecha_caducidad();
				String categoriaNombre = prod.getCategoria().getNombre();
				ProductoBarato p = new ProductoBarato(id, nombre, precio, fecha, categoriaNombre);
				productosBaratos.add(p);
				productoBaratoRepositorio.save(p);
			}
		}
		// Escribir en un fichero de objetos
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("ProductosBaratos.obj");
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			for (ProductoBarato p : productosBaratos) {
				oos.writeObject(p);
			}
			oos.close();
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Escribir en un fichero de texto

		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter("ProductosBaratos.txt");
			bw = new BufferedWriter(fw);
			for (ProductoBarato p : productosBaratos) {
				bw.write(p + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "Productos importados";

	}

	@PutMapping("/producto/{id}")
	public ResponseEntity<?> editarProducto(@RequestBody CreateProductoDTO editar, @PathVariable Long id) {

		if (!productoRepositorio.existsById(id))
			throw new ProductoNotFoundException(id);

		Producto n = productoDTOConverter.convertirAProd(editar);
		n.setId(id);
		// si en el objeto editar no mandamos ciertos campos, debemos mantener lo que el
		// objeto tiene
		// guardado en la BD
		if (editar.getCategoriaIdcat() == null)
			n.setCategoria(productoRepositorio.findById(id).get().getCategoria());
		if (editar.getNombre() == null)
			n.setNombre(productoRepositorio.findById(id).get().getNombre());
		if (editar.getPrecio() == 0.0)
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

	@DeleteMapping("/productosBaratos")
	public ResponseEntity<?> borrarProductosBaratos() {
		productoRepositorio.deleteAll();
		return ResponseEntity.noContent().build();

	}

//AQUI ES DONDE EJECUTA LO QUE SE MUESTRA CUANDO TENEMOS UN ERROR 404 PQ NO SE HA ENCONTRADO
	// cuando se produzca un error de este tipo ejecuta este método
	@ExceptionHandler(ProductoNotFoundException.class)
	public ResponseEntity<ApiError> handleProductoNoEncontrado(ProductoNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}

//EXCEPCION DE CATEGORIA	
	@ExceptionHandler(CategoriaNotFoundException.class)
	public ResponseEntity<ApiError> handleCategoriaNoEncontrado(CategoriaNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}

//ESTE SE EJECUTA CUANDO HAY UN ERROR DE 500 DE QUE NO HAYA ENVIADO LOS DATOS DEL JSON PQ SE 
	// HAYA CAIDO EL SERVIDOR
	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<ApiError> handleJsonMappingException(JsonProcessingException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.BAD_REQUEST);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}

}
