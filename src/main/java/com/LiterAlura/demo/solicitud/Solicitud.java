package com.LiterAlura.demo.solicitud;

import java.net.URI;
import java.net.http.HttpRequest;

public class Solicitud {

    private static final String URL = "https://gutendex.com/books/?";

    public static HttpRequest crearSolicitudBusqueda (String consulta) {

        String url = URL + consulta;

        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .build();

    }



}
