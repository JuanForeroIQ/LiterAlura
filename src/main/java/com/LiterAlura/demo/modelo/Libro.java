package com.LiterAlura.demo.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {

    private int id;

    private String title;

    private List<Autor> authors;

    @JsonAlias("download_count")
    private int downloadCount;

    // Añadir el campo languages
    private List<String> languages;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    // Getter y Setter para languages
    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        // Modificado para imprimir los detalles de los autores fuera de los corchetes
        StringBuilder authorsStr = new StringBuilder();
        for (Autor autor : authors) {
            authorsStr.append(autor.toString()).append(" ");  // Añadir detalles de autores
        }

        // Extraer el primer lenguaje
        String language = languages != null && !languages.isEmpty() ? languages.get(0) : "Desconocido";

        return "Libro - {" +
                "Titulo='" + title + "\', " +
                "Idiomas=" + language + ", " +
                authorsStr.toString() +
                ", No.Descargas=" + downloadCount +
                '}' + "\n";
    }
}
