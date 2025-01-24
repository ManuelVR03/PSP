package com.ejemplos.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplos.modelos.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController1 {
	
	@GetMapping("/index")
	public String index() {
		return ("index");
	}
	
	@GetMapping("index2")
	public String index2 (Model model) {
		model.addAttribute("titulo", "Hola Spring: Pasar datos del controlador a la vista con la interfaz Model");
		return ("index2");
	}
	
	@RequestMapping("/perfil")
	public String perfil (Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("José Luis");
		usuario.setApellido("Rus Rus");
		//usuario.setEmail("rrjose@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil ".concat(usuario.getNombre()));
		
		return "perfil";
	}

	@GetMapping("/listar1")
	public String listar1 (Model model) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
	@GetMapping("/listar2")
	public String listar2 (Model model) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Juan", "Pérez", "juan.perez@example.com"));
        usuarios.add(new Usuario("María", "Gómez", "maria.gomez@example.com"));
        usuarios.add(new Usuario("Carlos", "Fernández", "carlos.fernandez@example.com"));
        usuarios.add(new Usuario("Ana", "López", "ana.lopez@example.com"));
        usuarios.add(new Usuario("Luis", "Martínez", "luis.martinez@example.com"));
        usuarios.add(new Usuario("Sofía", "Rodríguez", null)); // Usuario sin email
        usuarios.add(new Usuario("Miguel", "Sánchez", "miguel.sanchez@example.com"));
        usuarios.add(new Usuario("Lucía", "Díaz", "lucia.diaz@example.com"));
        usuarios.add(new Usuario("Pedro", "Torres", null)); // Usuario sin email
        usuarios.add(new Usuario("Elena", "Ramírez", "elena.ramirez@example.com"));
        model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
}
