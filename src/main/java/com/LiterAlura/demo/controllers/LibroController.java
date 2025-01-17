package com.LiterAlura.demo.controllers;

import com.LiterAlura.demo.modelo.Autor;
import com.LiterAlura.demo.modelo.Libro;
import com.LiterAlura.demo.service.LibroService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping("/guardar")
    public Libro guardarLibro(@RequestBody Libro libro) {
        for (Autor autor : libro.getAuthors()) {
            autor.setLibros(List.of(libro)); // Sincroniza la relación bidireccional
        }
        return libroService.guardarLibro(libro);
    }
}
