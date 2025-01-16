package com.ejemplos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
