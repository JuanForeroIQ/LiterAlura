package com.LiterAlura.demo.procesador;

import com.LiterAlura.demo.modelo.Libro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Procesador {

    public List<Libro> procesarJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resultado resultado = objectMapper.readValue(json, Resultado.class);
            return Arrays.asList(resultado.getResults());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(); // Devuelve una lista vacía si ocurre un error
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Resultado {
        private Libro[] results;

        public Libro[] getResults() {
            return results;
        }

        public void setResults(Libro[] results) {
            this.results = results;
        }
    }
}
