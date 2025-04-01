package exceptions;

/**
 * Excepción personalizada para indicar que una reserva no está disponible.
 * Esta excepción se lanza cuando un cliente intenta realizar una reserva
 * pero ya tiene el máximo permitido de reservas activas.
 */
public class ReservaNoDisponibleException extends Exception {
    public ReservaNoDisponibleException(String message) {
        super(message);
    }
}

