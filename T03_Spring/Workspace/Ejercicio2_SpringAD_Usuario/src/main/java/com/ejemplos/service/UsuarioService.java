package com.ejemplos.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.modelo.Usuario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	@Value("${rutaapi}")
	String basePath;

	@Autowired
	private RestTemplate restTemplate;

	public List<Usuario> obtenerUsuarios() {
		Usuario[] response = restTemplate.getForObject(basePath + "/usuario", Usuario[].class);
		return Arrays.asList(response);
	}

	public Usuario obtenerUsuario(Long id) {
		return restTemplate.getForObject(basePath + "/usuario/" + id, Usuario.class);
	}
	
	public void actualizarUsuario(Long id, Usuario usuario) {
		restTemplate.put(basePath+"/usuario/"+id, usuario);
	}

	public void borraUsuario(Long id) {
		restTemplate.delete(basePath + "/usuario/" + id);
	}

	public void creaUsuario(Usuario usuario) {
		restTemplate.postForObject(basePath + "/usuario", usuario, Usuario.class);
	}

}
