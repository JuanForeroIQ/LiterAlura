package com.LiterAlura.demo.repository;

import com.LiterAlura.demo.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}