package com.LiterAlura.demo.cliente;

import java.net.http.HttpClient;


public class Cliente {

    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL) // Esto permitirá seguir las redirecciones
            .build();

    public static HttpClient getClient() {
        return client;
    }

}
