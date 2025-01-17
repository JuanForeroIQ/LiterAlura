package com.LiterAlura.demo.service;

import com.LiterAlura.demo.modelo.Autor;
import com.LiterAlura.demo.modelo.Libro;
import com.LiterAlura.demo.repository.LibroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Transactional
    public Libro guardarLibro(Libro libro) {
        for (Autor autor : libro.getAuthors()) {
            autor.getLibros().add(libro);  // Asegura la sincronización de ambas direcciones
        }
        return libroRepository.save(libro);
    }
}
