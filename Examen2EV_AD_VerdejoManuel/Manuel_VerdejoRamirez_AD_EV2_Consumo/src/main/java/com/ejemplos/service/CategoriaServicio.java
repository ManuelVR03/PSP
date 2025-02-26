package com.ejemplos.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.modelo.Categoria;
import com.ejemplos.modelo.Producto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServicio {
	
	@Value("${rutaapi}")
	String basePath;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Categoria> obtenerCategorias(){
		Categoria[] response = restTemplate.getForObject(basePath + "/apiCategoria/categoria", Categoria[].class);
		return Arrays.asList(response);
	}
	
	public List<Producto> obtenerProductosCat(String nombre){
		Producto[] response = restTemplate.getForObject(basePath + "/producto", Producto[].class);
		List<Producto> filtrados = new ArrayList<>();
		for (Producto p: response) {
			if (p.getCategoriaNombre().equalsIgnoreCase(nombre))
				filtrados.add(p);
		}
		return filtrados;
	}

}
