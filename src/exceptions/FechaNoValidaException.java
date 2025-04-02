package exceptions;

/**
 * Excepción personalizada para manejar el caso en que una fecha no es válida.
 * Esta excepción se lanza cuando se intenta realizar una reserva con una fecha no válida.
 */
public class FechaNoValidaException extends Exception {
    public FechaNoValidaException(String message) {
        super(message);
    }
    
}
