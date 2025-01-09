package com.LiterAlura.demo.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.ArrayList;
import java.util.List;

public class ListaAutores {

    // Lista para almacenar los autores
    private List<AutorInfo> autores = new ArrayList<>();

    // Clase interna para almacenar la información del autor
    public static class AutorInfo {

        private String name;
        private int birthYear;
        private int deathYear;

        public AutorInfo(String name, int birthYear, int deathYear) {

            this.name = name;
            this.birthYear = birthYear;
            this.deathYear = deathYear;

        }

        @Override
        public String toString() {

            return "Nombre: " + name + "\nAño de nacimiento: " + birthYear +
                    "\nAño de fallecimiento: " + deathYear;

        }
    }

    // Metodo para agregar un autor a la lista
    public void agregarAutor(String name, int birthYear, int deathYear) {

        autores.add(new AutorInfo(name, birthYear, deathYear));

    }

    // Metodo para obtener la lista de autores
    public List<ListaAutores.AutorInfo> obtenerAutores() {

        return autores;

    }
}
