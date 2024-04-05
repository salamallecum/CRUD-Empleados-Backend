package com.gestion.empleados.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Esta clase se encarga de gestionar lo que debe hacer cuando no
// encuentra un empleado, manejando la excepción de forma personalizada
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    //Constructor
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
