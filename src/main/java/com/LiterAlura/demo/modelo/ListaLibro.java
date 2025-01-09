package com.LiterAlura.demo.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaLibro {

    // Lista para almacenar los libros
    private List<LibroInfo> libros = new ArrayList<>();

    // Clase interna para almacenar la información del libro
    public static class LibroInfo {
        private String titulo;
        private String autor;
        private String idioma;
        private int numDescargas;

        public LibroInfo(String titulo, String autor, String idioma, int numDescargas) {
            this.titulo = titulo;
            this.autor = autor;
            this.idioma = idioma;
            this.numDescargas = numDescargas;
        }

        @Override
        public String toString() {
            return "Título: " + titulo + "\nAutor: " + autor + "\nIdioma: " + idioma + "\nNúmero de Descargas: " + numDescargas;
        }
    }

    // Metodo para agregar un libro a la lista
    public void agregarLibro(String titulo, String autor, String idioma, int numDescargas) {
        libros.add(new LibroInfo(titulo, autor, idioma, numDescargas));
    }

    // Metodo para obtener la lista de libros
    public List<LibroInfo> obtenerLibros() {
        return libros;
    }
}
