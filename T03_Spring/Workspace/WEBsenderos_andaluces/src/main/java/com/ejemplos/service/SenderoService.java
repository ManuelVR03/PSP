package com.ejemplos.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.modelo.Media;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SenderoService {

	@Value("${rutaapi}")
	String basePath;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Media> obtenerSenderos(){
		Media[] response = restTemplate.getForObject(basePath+"/senderoweb", Media[].class);
		List<Media> filtrados = new ArrayList<>();
		for (Media sendero: response) {
			if (sendero.getDificultad().equalsIgnoreCase("media"))
				filtrados.add(sendero);
		}
		return filtrados;
		
	}
}
