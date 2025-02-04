package com.ejemplos.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SenderoRepositorio extends JpaRepository<Sendero, String>{

	@Query("SELECT s FROM Sendero s ORDER BY s.cod_sendero DESC LIMIT 1")
	Sendero findLastSendero();
}
