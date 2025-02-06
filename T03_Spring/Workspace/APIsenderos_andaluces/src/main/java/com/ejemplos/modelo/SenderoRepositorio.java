package com.ejemplos.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SenderoRepositorio extends JpaRepository<Sendero, String>{
	
}
