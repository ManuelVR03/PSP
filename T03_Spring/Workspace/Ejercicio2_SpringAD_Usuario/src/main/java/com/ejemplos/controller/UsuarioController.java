package com.ejemplos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ejemplos.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/index")
	public String inicio(Model model) {
		model.addAttribute("titulo", "Prueba del index");
		return "index";
	}

	@GetMapping("/listado")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
		return "listar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		usuarioService.borraUsuario(id);
		return "redirect:/listado";
	}
}
