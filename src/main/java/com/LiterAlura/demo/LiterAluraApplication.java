package com.LiterAlura.demo;

import com.LiterAlura.demo.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LiterAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Bean
	CommandLineRunner run(Principal principal) {
		return args -> {
			String respuesta = principal.busquedaLibros();

			// Cambiar la comparación para comparar el contenido de las cadenas
			while (!respuesta.equals("0")) {

				respuesta = principal.busquedaLibros();
			}

		};
	}

}

