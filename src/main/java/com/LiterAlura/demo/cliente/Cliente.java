package com.LiterAlura.demo.cliente;

import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Optional;

public class Cliente {

    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL) // Esto permitirá seguir las redirecciones
            .build();

    public static HttpClient getClient() {
        return client;
    }

}
