package com.LiterAlura.demo.respuesta;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Respuesta {

    public static String procesoRespuesta(HttpClient cliente, HttpRequest solicitud) {
        try {

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() == 200) {

                // Si la respuesta es exitosa (200 OK), retornamos el cuerpo
                // System.out.println("Respuesta exitosa: " + respuesta.body());
                return respuesta.body();  // Retorna la respuesta exitosa

            } else {

                // Si hay un error, mostramos el código de estado
                System.out.println("Error: Código de estado " + respuesta.statusCode());
                return "Error: Código de estado " + respuesta.statusCode();  // Retorna el mensaje de error

            }
        } catch (IOException | InterruptedException e) {

            e.printStackTrace();
            return "Error: " + e.getMessage();  // Retorna el mensaje de error en caso de excepción

        }
    }


}
