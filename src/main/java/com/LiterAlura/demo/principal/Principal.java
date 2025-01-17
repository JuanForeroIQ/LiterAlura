package com.LiterAlura.demo.principal;

import com.LiterAlura.demo.cliente.Cliente;
import com.LiterAlura.demo.modelo.Libro;
import com.LiterAlura.demo.modelo.ListaAutores;
import com.LiterAlura.demo.procesador.Procesador;
import com.LiterAlura.demo.respuesta.Respuesta;
import com.LiterAlura.demo.solicitud.Solicitud;
import org.springframework.stereotype.Service;

import java.util.*;

import com.LiterAlura.demo.modelo.ListaLibro;

@Service
public class Principal {

    private ListaLibro listaLibro = new ListaLibro();
    private ListaAutores listaAutores = new ListaAutores();

    public String busquedaLibros() {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Elija la opción a través de su número: \n" +
                "1- Buscar libro por título.\n" +
                "2- Listar libros registrados.\n" +
                "3- Listar autores registrados.\n" +
                "4- Listar autores vivos en un determinado año.\n" +
                "5- Listar libros por idioma.\n" +
                "0- Salir.\n");

        int consulta;
        while (!myObj.hasNextInt()) {

            System.out.println("Por favor, ingrese un número válido.");
            myObj.next();

        }

        consulta = myObj.nextInt();
        myObj.nextLine();  // Consumir la línea pendiente

        switch (consulta) {

            case 1:

                System.out.print("Ingrese el título del libro: ");
                String libro = myObj.nextLine().replace(" ", "%20");
                String enlace = "search=" + libro;

                var cliente = Cliente.getClient();
                var solicitud = Solicitud.crearSolicitudBusqueda(enlace);
                String respuesta = Respuesta.procesoRespuesta(cliente, solicitud);
                Procesador procesador = new Procesador();
                List<Libro> libros = procesador.procesarJson(respuesta);

                if (libros.isEmpty()) {
                    System.out.println("No se encontraron libros.");
                    return "No se encontraron libros.";
                }

                for (Libro l : libros) {
                    // Aquí agregamos el libro a la lista
                    listaLibro.agregarLibro(l.getTitle(), l.getAuthors().get(0).getName(), l.getLanguages().get(0), l.getDownloadCount());
                    listaAutores.agregarAutor(l.getAuthors().get(0).getName(), l.getAuthors().get(0).getBirthYear(), l.getAuthors().get(0).getDeathYear());
                    System.out.println(l);
                    break;
                }

                return "1";

            case 2:

                List<ListaLibro.LibroInfo> librosRegistrados = listaLibro.obtenerLibros();

                if (librosRegistrados.isEmpty()) {

                    System.out.println("No hay libros registrados.");

                } else {

                    for (ListaLibro.LibroInfo libroInfo : librosRegistrados) {
                        System.out.println(libroInfo);
                        System.out.println("\n");
                    }

                }

                return "2";

            case 3:

                List<ListaAutores.AutorInfo> autoresRegistrados = listaAutores.obtenerAutores();

                if (autoresRegistrados.isEmpty()) {

                    System.out.println("No hay autores registrados.");

                } else {

                    for (ListaAutores.AutorInfo autorInfo : autoresRegistrados) {
                        System.out.println(autorInfo);
                        System.out.println("\n");
                    }

                }

                return "3";

            case 4:

                // Pedir al usuario que ingrese un año específico
                System.out.print("Ingrese el año para verificar los autores vivos en ese año: ");
                int ano = myObj.nextInt();

                // Obtener la lista de autores vivos en el año ingresado
                List<ListaAutores.AutorInfo> autoresVivos = listaAutores.obtenerAutoresVivosEnAno(ano);

                if (autoresVivos.isEmpty()) {

                    System.out.println("No hay autores vivos en ese año.");

                } else {

                    System.out.println("Autores vivos en el año " + ano + ":");

                    for (ListaAutores.AutorInfo autor : autoresVivos) {
                        System.out.println(autor);
                        System.out.println("\n");
                    }

                }

                return "4";

            case 5:
                // Obtener la lista de libros registrados
                List<ListaLibro.LibroInfo> librosPorIdiomaRegistrados = listaLibro.obtenerLibros();

                // Crear un mapa para almacenar los libros agrupados por idioma
                Map<String, List<ListaLibro.LibroInfo>> librosPorIdioma = new HashMap<>();

                // Agrupar los libros por idioma
                for (ListaLibro.LibroInfo libroInfo : librosPorIdiomaRegistrados) {
                    String idioma = libroInfo.idioma;
                    librosPorIdioma.computeIfAbsent(idioma, k -> new ArrayList<>()).add(libroInfo);
                }

                // Verificar si hay libros registrados
                if (librosPorIdiomaRegistrados.isEmpty()) {
                    System.out.println("No hay libros registrados.");
                } else {
                    // Imprimir los libros agrupados por idioma
                    for (Map.Entry<String, List<ListaLibro.LibroInfo>> entry : librosPorIdioma.entrySet()) {
                        System.out.println("Idioma: " + entry.getKey());
                        for (ListaLibro.LibroInfo libroInfo : entry.getValue()) {
                            System.out.println(libroInfo);
                            System.out.println("\n");
                        }
                    }
                }

                return "5";

            case 0:

                System.out.println("Saliendo del programa...");
                return "0";

            default:

                System.out.println("Opción no válida.");
                return "Opción no válida";
        }
    }
}
