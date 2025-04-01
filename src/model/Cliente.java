package model;

public class Cliente {
    // Atributos
    private String DNI;
    private String nombreCompleto;
    // Historial de reservad (ver como implementar)
    private int reservasActivas; // Máximo 3 reservas activas

    // Constructor
    public Cliente(String DNI, String nombreCompleto) {
        this.DNI = DNI;
        this.nombreCompleto = nombreCompleto;
        this.reservasActivas = 0; // Inicialmente no tiene reservas activas
    }
}
