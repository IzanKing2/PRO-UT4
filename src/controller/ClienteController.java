package controller;

import java.io.File;
import model.Cliente;

// Excepción personalizada para errores de validación de DNI
class DNIException extends Exception {
    public DNIException(String mensaje) {
        super(mensaje);
    }
}

public class ClienteController {
}
