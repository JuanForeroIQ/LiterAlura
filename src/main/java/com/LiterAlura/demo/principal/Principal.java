package com.LiterAlura.demo.principal;

import com.LiterAlura.demo.cliente.Cliente;
import com.LiterAlura.demo.respuesta.Respuesta;
import com.LiterAlura.demo.solicitud.Solicitud;
import org.springframework.stereotype.Service;

@Service
public class Principal {

    public String busquedaLibros (String consulta) {

        var cliente = Cliente.getClient();
        var solicitud = Solicitud.crearSolicitudBusqueda(consulta);

        return Respuesta.procesoRespuesta(cliente, solicitud);

    }


}
