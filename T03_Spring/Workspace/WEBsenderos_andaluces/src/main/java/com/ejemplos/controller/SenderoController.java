package com.ejemplos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.ejemplos.modelo.Media;
import com.ejemplos.modelo.MediaRepositorio;
import com.ejemplos.service.SenderoService;

@Controller
public class SenderoController {

	@Autowired
	private SenderoService senderoService;
	
	@Autowired
	private MediaRepositorio mediaRepositorio;
	
	@GetMapping("/media")
	public ResponseEntity<?> obtenerMedia() {
		List<Media> result = mediaRepositorio.findAll();
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<?> mediaSendero(){
		List<Media> result = senderoService.obtenerSenderos();
		return ResponseEntity.status(HttpStatus.CREATED).body(mediaRepositorio.saveAll(result));
	}
	
	@GetMapping("/dificultadMedia")
	public String listarMedia(Model model) {
		try {
			model.addAttribute("senderos", mediaRepositorio.findAll());
		}catch (HttpClientErrorException.NotFound e) {
			model.addAttribute("senderos", new ArrayList<Media>());
		}
		return "mostrar";
	}
	
	@DeleteMapping("/borraSenderos")
	public ResponseEntity<?> borraSenderos() {
		mediaRepositorio.deleteAll();
		return ResponseEntity.noContent().build();
	}
}
