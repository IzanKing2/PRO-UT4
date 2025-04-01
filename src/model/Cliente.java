package model;

public class Cliente {
    private static final String HISTORIAL_FILE = "historial_reservas.txt";

    // Atributos
    private String DNI;
    private String nombreCompleto;
    private int reservasActivas; // Máximo 3 reservas activas

    // Constructor
    public Cliente(String DNI, String nombreCompleto) {
        this.DNI = DNI;
        this.nombreCompleto = nombreCompleto;
        this.reservasActivas = 0; // Inicialmente no tiene reservas activas
    }
}
