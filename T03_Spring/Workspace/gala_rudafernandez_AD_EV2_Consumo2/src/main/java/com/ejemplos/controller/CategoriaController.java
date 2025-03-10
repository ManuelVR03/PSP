package com.ejemplos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplos.DTO.Categoria;
import com.ejemplos.DTO.Producto;
import com.ejemplos.service.CategoriaService;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	//Mostrar listado categorias
	@GetMapping("/categoria")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de categorias");
		try {
			model.addAttribute("categorias", categoriaService.obtenerCategorias());
		}catch(Exception e) {
			model.addAttribute("categorias", new ArrayList<Categoria>());
		}
		return "mostrar";
	}
	
	@GetMapping("/categoria/{id}")
	public String listarProductos(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("titulo","Listado de productos");
		try {
			model.addAttribute("productos", categoriaService.obtenerProductos(id));
		}catch(Exception e) {
			model.addAttribute("productos", new ArrayList<Producto>());
		}
		return "mostrarProductos";
	}	
	
	//Formulario de creacion de producto
	@GetMapping(value="/form")
	public String crear(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		model.addAttribute("titulo", "Formulario de producto");
		return "formSinCSS";
	}
		
	@PostMapping(value="/form")
	public String guardar(Producto producto) {
		//Esto hace falta porque lo que producto espera es un objeto categoria y por el formulario recibe el id solo
		if(producto.getCategoria() == null || producto.getCategoria().getIdcat() == null) {
			return "redirect:/form";
		}else {
			Categoria categoria = categoriaService.obtenerCategoria(producto.getCategoria().getIdcat());
			if(categoria ==  null) {
				return "redirect:/form";
			}
			producto.setCategoria(categoria);
			categoriaService.crearProducto(producto);
			return "redirect:/categoria/" + categoria.getIdcat();
		}
		
	}
		
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model) {
		Producto producto;
			
		if(id > 0) {
			producto = categoriaService.obtenerProducto(id);
		}else {
			return "redirect:/categoria";
		}
		model.addAttribute("producto", producto);
		model.addAttribute("titulo", "Editar Producto");
		return "formSinCSS";
	}
}
