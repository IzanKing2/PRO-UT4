package exceptions;

/**
 * Excepción personalizada para manejar el caso en que no se encuentra un cliente.
 * Esta excepción se lanza cuando se intenta acceder a un cliente que no existe en el sistema.
 */
public class ClienteNoEncontradoException extends Exception {
    public ClienteNoEncontradoException(String message) {
        super(message);
    }
}
