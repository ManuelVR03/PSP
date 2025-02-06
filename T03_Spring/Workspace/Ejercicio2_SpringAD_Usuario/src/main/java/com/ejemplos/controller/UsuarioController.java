package com.ejemplos.controller;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.ejemplos.modelo.Usuario;
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
		try {
			model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
		}catch(HttpClientErrorException.NotFound e) {
			model.addAttribute("usuarios", new ArrayList<Usuario>());
		}
		return "listar";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model) {
		Usuario usuario;
		if (id > 0)
			usuario = usuarioService.obtenerUsuario(id);
		else
			return "redirect:/listado";
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Editar Usuario");
		return "formSinCSS";		
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		usuarioService.borraUsuario(id);
		return "redirect:/listado";
	}
	
	@GetMapping("/form")
	public String crear(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Formulario de usuario");
		return "formSinCSS";
	}
	
	@PostMapping("/form")
	public String guardar(Usuario usuario) {
		usuarioService.creaUsuario(usuario);
		return "redirect:/listado";
	}
}
