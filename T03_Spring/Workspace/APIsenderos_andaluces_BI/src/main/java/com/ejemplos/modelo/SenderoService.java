package com.ejemplos.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderoService{

	@Autowired
	public SenderoRepositorio senderoRepositorio;
	
	public String getNextCodSendero() {
		List<Sendero> senderos = senderoRepositorio.findAll();
		int maxNum = senderos.stream()
		        .map(Sendero::getCod_sendero)
		        .map(cod -> Integer.parseInt(cod.replace("sen", ""))) // Extraer número
		        .max(Integer::compareTo) // Obtener el máximo
		        .orElse(0) + 1;
		return "sen" + maxNum;
	}
}
