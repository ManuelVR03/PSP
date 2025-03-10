package com.ejemplos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.modelo.Categoria;
import com.ejemplos.modelo.CategoriaRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apiCategoria")
public class CategoriaController {
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@GetMapping("/categoria")
	public ResponseEntity<?> obtenerCategorias(){
		List<Categoria> result = categoriaRepositorio.findAll();
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(result);
	}
	

}
