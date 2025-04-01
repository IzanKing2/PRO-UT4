package model;

public class Cliente {
    
    // Atributos
    private String DNI;
    private String nombreCompleto;
    private int reservasActivas; // Máximo 3 reservas activas
    private final String HISTORIAL_FILE = "historial_reservas.txt";

    // Constructor
    public Cliente(String DNI, String nombreCompleto) {
        this.DNI = DNI;
        this.nombreCompleto = nombreCompleto;
        this.reservasActivas = 0; // Inicialmente no tiene reservas activas
    }

    // Getters y Setters
    public String getDNI() {
        return this.DNI;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public int getReservasActivas() {
        return this.reservasActivas;
    }

    public void setReservasActivas(int reservasActivas) {
        this.reservasActivas += reservasActivas;
    }

    public final String getHistorialFile() {
        return this.HISTORIAL_FILE;
    }
}
