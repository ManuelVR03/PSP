package com.ejemplos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class Ejer2AplicacionWebUsuariosAdApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejer2AplicacionWebUsuariosAdApplication.class, args);
	}

}
