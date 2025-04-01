package model;

public class Cliente {
    // Atributos
    private int idCliente;
    private String nombreCompleto;
    // Historial de reservad (ver como implementar)
    private int reservasActivas; // Máximo 3 reservas activas

    // Constructor
    public Cliente(int idCliente, String nombreCompleto) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.reservasActivas = 0; // Inicialmente no tiene reservas activas
    }
}
