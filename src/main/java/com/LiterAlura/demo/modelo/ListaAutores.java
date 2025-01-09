package com.LiterAlura.demo.modelo;

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

        // Métodos getter para acceder a la información
        public int getBirthYear() {
            return birthYear;
        }

        public int getDeathYear() {
            return deathYear;
        }

        public String getName() {
            return name;
        }
    }

    // Metodo para agregar un autor a la lista
    public void agregarAutor(String name, int birthYear, int deathYear) {
        autores.add(new AutorInfo(name, birthYear, deathYear));
    }

    // Metodo para obtener la lista de autores
    public List<AutorInfo> obtenerAutores() {
        return autores;
    }

    // Metodo para obtener los autores vivos en un año específico
    public List<AutorInfo> obtenerAutoresVivosEnAno(int ano) {
        List<AutorInfo> autoresVivos = new ArrayList<>();

        for (AutorInfo autor : autores) {
            // Verifica si el autor estaba vivo en el año ingresado
            if (autor.getBirthYear() > 0 && autor.getBirthYear() <= ano &&
                    (autor.getDeathYear() == 0 || autor.getDeathYear() >= ano)) {

                autoresVivos.add(autor);

            }

        }

        return autoresVivos;
    }
}
