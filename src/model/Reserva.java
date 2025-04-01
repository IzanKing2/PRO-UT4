package model;

import java.time.LocalDateTime;

public class Reserva {

    // Atributos
    private int idReserva = 0; // ID de la reserva (se genera automáticamente)
    private int numeroHabitacion;
    private Cliente cliente;            // Cliente que realiza la reserva
    private LocalDateTime fechaInicioReserva;   
    private LocalDateTime fechaFinReserva; // Máximo de 3 meses de reserva
    private LocalDateTime fechaCkeckIn;
    private LocalDateTime fechaCheckOut;     
    private double precioTotal;         // Precio total de la reserva (depende del tipo de habitación y número de noches)


    public Reserva(int numeroHabitacion, Cliente cliente, LocalDateTime fechaCheckIn, LocalDateTime fechaCheckOut) {
        idReserva++;
        this.numeroHabitacion = numeroHabitacion;
        this.cliente = cliente;
        this.fechaCkeckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
    }

    // Getters y Setters

    public Cliente getCliente() {
        return cliente;
    }

    public int getIdReserva() {
        return idReserva;
    }

}