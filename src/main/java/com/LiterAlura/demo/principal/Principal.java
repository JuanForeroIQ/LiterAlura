package com.LiterAlura.demo.principal;

import com.LiterAlura.demo.cliente.Cliente;
import com.LiterAlura.demo.modelo.Libro;
import com.LiterAlura.demo.procesador.Procesador;
import com.LiterAlura.demo.respuesta.Respuesta;
import com.LiterAlura.demo.solicitud.Solicitud;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class Principal {

    public String busquedaLibros() {

        Scanner myObj = new Scanner(System.in);  // Crear objeto Scanner para leer la entrada
        System.out.println("Elija la opción a través de su número: \n" +
                "1- Buscar libro por título.\n" +
                "2- Listar libros registrados.\n" +
                "3- Listar autores registrados.\n" +
                "4- Listar autores vivos en un determinado año.\n" +
                "5- Listar libros por idioma.\n" +
                "0- Salir.\n");

        int consulta;

        // Asegurarse de que el usuario ingrese un número válido
        while (!myObj.hasNextInt()) {

            System.out.println("Por favor, ingrese un número válido.");
            myObj.next(); // Descarta la entrada incorrecta

        }

        consulta = myObj.nextInt();  // Leer entrada del usuario

        // Consumir la línea pendiente
        myObj.nextLine();

        switch (consulta) {

            case 1:

                System.out.print("Ingrese el autor: ");
                String autor = myObj.nextLine();  // Leer el autor
                System.out.print("Ingrese el título del libro: ");
                String libro = myObj.nextLine();  // Leer el título del libro
                String enlace = "search=" + autor + "%20" + libro;

                var cliente = Cliente.getClient();
                var solicitud = Solicitud.crearSolicitudBusqueda(enlace);

                // Obtener la respuesta de la búsqueda (Ahora es un String)
                String respuesta = Respuesta.procesoRespuesta(cliente, solicitud);

                // Crea una instancia de ProcesadorLibros
                Procesador procesador = new Procesador();

                // Procesar la respuesta JSON y obtener la lista de libros
                List<Libro> libros = procesador.procesarJson(respuesta);

                // Verificar si se obtuvieron libros
                if (libros.isEmpty()) {
                    System.out.println("No se encontraron libros.");
                    return "No se encontraron libros.";
                }

                // Imprimir los libros encontrados
                for (Libro l : libros) {
                    System.out.println(l);
                }

                return "1";

            case 2:

                return "2";

            case 0:

                System.out.println("Saliendo del programa...");
                return "0";

            default:

                System.out.println("Opción no válida.");
                return "Opción no válida";
        }
    }
}
