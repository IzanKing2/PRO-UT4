package exceptions;

// Excepción personalizada para manejar el caso en que no se encuentra una habitación
public class HabitacionNoEncontradaException extends Exception {
    public HabitacionNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
