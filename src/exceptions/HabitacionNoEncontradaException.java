package exceptions;

/**
 * Excepción personalizada para manejar el caso en que no se encuentra una habitación.
 * Esta excepción se lanza cuando se intenta acceder a una habitación que no existe en el sistema.
 */
public class HabitacionNoEncontradaException extends Exception {
    public HabitacionNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
