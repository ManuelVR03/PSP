package com.ejemplos.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Municipio {

	@Id
	private String cod_municipio;
	private String nombre_municipio;
	@JsonIgnoreProperties({"municipio"})
	@OneToMany(mappedBy="municipio")
	private List<Sendero> senderos;
	
	public void addSenderos(Sendero s) {
		senderos.add(s);
	}
	
	public void deleteSendero(Sendero s) {
		senderos.remove(s);
	}
}
