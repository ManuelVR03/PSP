package com.ejemplos.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ejemplos.modelo.Categoria;
import com.ejemplos.modelo.Producto;
import com.ejemplos.service.CategoriaServicio;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaServicio categoriaService;
	
	@GetMapping("/listadoCategorias")
	public String listadoCat(Model model) {
		model.addAttribute("titulo", "Listado de Categorías");
		try {
			model.addAttribute("categorias", categoriaService.obtenerCategorias());
		}catch(Exception e) {
			model.addAttribute("categorias", new ArrayList<Categoria>());
		}
		return "listadoCat";
	}
	
	@GetMapping("/obtenerProductos/{nombre}")
	public String listadoProd(@PathVariable(value = "nombre") String nombre, Model model) {
		model.addAttribute("titulo", "Listado de Productos");
		try {
			model.addAttribute("productos", categoriaService.obtenerProductosCat(nombre));
		}catch(Exception e) {
			model.addAttribute("productos", new ArrayList<Producto>());
		}
		return "listadoProd";
	}

}
