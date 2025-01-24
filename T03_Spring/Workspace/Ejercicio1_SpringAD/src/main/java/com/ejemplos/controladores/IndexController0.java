package com.ejemplos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController0 {
	
	@GetMapping({"/index", "/", "/home"})
	public String index() {
		return ("index");
	}

	
}
