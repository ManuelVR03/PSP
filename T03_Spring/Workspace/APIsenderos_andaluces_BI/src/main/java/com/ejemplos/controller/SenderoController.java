package com.ejemplos.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.DTO.CreateSenderoDTO;
import com.ejemplos.DTO.SenderoDTO;
import com.ejemplos.DTO.SenderoDTOConverter;
import com.ejemplos.DTO.SenderoDTOWeb;
import com.ejemplos.excepciones.ApiError;
import com.ejemplos.excepciones.MunicipioNotFoundException;
import com.ejemplos.excepciones.SenderoNotFoundException;
import com.ejemplos.modelo.Municipio;
import com.ejemplos.modelo.MunicipioRepositorio;
import com.ejemplos.modelo.Sendero;
import com.ejemplos.modelo.SenderoRepositorio;
import com.ejemplos.modelo.SenderoService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apiSenderos")
public class SenderoController {

	@Autowired
	private SenderoRepositorio senderoRepositorio;
	
	@Autowired
	private MunicipioRepositorio municipioRepositorio;
	
	@Autowired 
	public SenderoService senderoService;
	
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
	
	@GetMapping("/municipio")
	public ResponseEntity<?> obtenerMunicipios() {
		List<Municipio> result = municipioRepositorio.findAll();
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}
	}
	
	@GetMapping("/senderoweb")
	public ResponseEntity<?> obtenerSenderosWeb() {
		List <Sendero> result = senderoRepositorio.findAll();
		if (result.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			List<SenderoDTOWeb> dtoList = result.stream().map(senderoDTOConverter::convertirADtoWeb).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	
	@GetMapping("/sendero/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable String id) {
		Sendero result = senderoRepositorio.findById(id).orElse(null);
		if (result == null)
			throw new SenderoNotFoundException(id);
		SenderoDTO dto = senderoDTOConverter.convertirADto(result);
		return ResponseEntity.ok(dto);
		
	}
	
	@PostMapping("/sendero")
	public ResponseEntity<?> nuevoSendero(@RequestBody CreateSenderoDTO nuevo){
		if(!municipioRepositorio.existsById(nuevo.getMunicipioCod_municipio())) throw new MunicipioNotFoundException(nuevo.getMunicipioCod_municipio());
		Sendero s = senderoDTOConverter.convertirASend(nuevo);
		s.setCod_sendero(senderoService.getNextCodSendero());
		List<Sendero> senderos = new ArrayList<>();
		senderos.add(s);
		s.getMunicipio().setSenderos(senderos);
		return ResponseEntity.status(HttpStatus.CREATED).body(senderoRepositorio.save(s));
	}
	
	@PutMapping("/sendero/{id}")
	public ResponseEntity<?> editarSendero(@RequestBody CreateSenderoDTO editar, @PathVariable String id) {
		if (!senderoRepositorio.existsById(id)) throw new SenderoNotFoundException(id);
		Sendero aux = senderoRepositorio.findById(id).get();
		Sendero s = senderoDTOConverter.convertirASend(editar);
		s.setCod_sendero(id);
		if (editar.getNombre() == null)
			s.setNombre(aux.getNombre());
		if (editar.getDistancia() == null)
			s.setDistancia(aux.getDistancia());
		if (editar.getDificultad() == null)
			s.setDificultad(aux.getDificultad());
		if (editar.getFecha_creacion() == null)
			s.setFecha_creacion(aux.getFecha_creacion());
		if(!municipioRepositorio.existsById(editar.getMunicipioCod_municipio())) throw new MunicipioNotFoundException(id);
		if(!s.getMunicipio().getSenderos().contains(s))
			s.getMunicipio().addSenderos(s);
		return ResponseEntity.ok(senderoRepositorio.save(s));		
	}
	
	@DeleteMapping("sendero/{id}")
	public ResponseEntity<?> borrarSendero(@PathVariable String id){
		Sendero result = senderoRepositorio.findById(id).orElse(null);
		if (result == null)
			throw new SenderoNotFoundException(id);
		senderoRepositorio.delete(result);
		result.getMunicipio().deleteSendero(result);
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(SenderoNotFoundException.class)
	public ResponseEntity<ApiError> handleSenderoNoEncontrado(SenderoNotFoundException ex){
		ApiError apiError = new ApiError();
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	@ExceptionHandler(MunicipioNotFoundException.class)
	public ResponseEntity<ApiError> handleMunicipioNoEncontrado(MunicipioNotFoundException ex){
		ApiError apiError = new ApiError();
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<ApiError> handleJsonMappingException(JsonProcessingException ex) {
		ApiError apiError = new ApiError();
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
}
