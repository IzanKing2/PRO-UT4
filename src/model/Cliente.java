package model;

import java.util.ArrayList;

public class Cliente {
    
    // Atributos
    private String DNI;
    private String nombreCompleto;
    private int reservasActivas; // Máximo 3 reservas activas
    private ArrayList<Reserva> reservas; // Lista de reservas del cliente>
    private final String HISTORIAL_FILE = "historial_reservas.txt";
    

    // Constructor
    public Cliente(String DNI, String nombreCompleto) {
        this.DNI = DNI;
        this.nombreCompleto = nombreCompleto;
        this.reservasActivas = 0; // Inicialmente no tiene reservas activas
        this.reservas = new ArrayList<>(); // Inicializar la lista de reservas
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

    public final String getHistorialFile() {
        return this.HISTORIAL_FILE;
    }

    public ArrayList<Reserva> getReservas() {
        return this.reservas; // Obtener la lista de reservas del cliente
    }

    // Setters
    public void setReservas(Reserva reserva) {
        this.reservas.add(reserva); // Añadir reservas a la lista de reservas del cliente
    }

    public void setReservasActivas(int reservasActivas) {
        this.reservasActivas += reservasActivas;
    }
}
