package com.LiterAlura.demo;

import com.LiterAlura.demo.modelo.Libro;
import com.LiterAlura.demo.principal.Principal;
import com.LiterAlura.demo.procesador.Procesador;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LiterAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Bean
	CommandLineRunner run(Principal principal) {
		return args -> {
			String respuesta = principal.busquedaLibros("1");

			// Crea una instancia de ProcesadorLibros
			Procesador procesador = new Procesador();
			List<Libro> libros = procesador.procesarJson(respuesta);

			// Muestra los resultados deserializados
			libros.forEach(System.out::println);
		};
	}

	}

