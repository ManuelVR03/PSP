package com.ejemplos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.DTO.CreateSenderoDTO;
import com.ejemplos.DTO.SenderoDTO;
import com.ejemplos.DTO.SenderoDTOConverter;
import com.ejemplos.modelo.Sendero;
import com.ejemplos.modelo.SenderoRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SenderoController {

	@Autowired
	private SenderoRepositorio senderoRepositorio;
	
	@Autowired
	private SenderoDTOConverter senderoDTOConverter;
	
	@GetMapping("/sendero")
	public ResponseEntity<?> obtenerTodos() {
		List<Sendero> result = senderoRepositorio.findAll();
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			List<SenderoDTO> dtoList = result.stream().map(senderoDTOConverter::convertirADto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	
	@PostMapping("/sendero")
	public ResponseEntity<?> nuevoSendero(@RequestBody CreateSenderoDTO nuevo){
		Sendero s = senderoDTOConverter.convertirASend(nuevo);
		Sendero last = senderoRepositorio.findLastSendero();
		int cod = Integer.parseInt(last.getCod_sendero().substring(3))+1;
		String newCod = "sen" + cod;
		s.setCod_sendero(newCod);
		return ResponseEntity.status(HttpStatus.CREATED).body(senderoRepositorio.save(s));
	}
}
