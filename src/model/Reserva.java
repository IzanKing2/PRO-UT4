package model;

import java.time.LocalDateTime;

public class Reserva {

    // Atributos
    private int idReserva;
    private int numeroHabitacion;
    private Cliente cliente;            // Cliente que realiza la reserva
    private LocalDateTime fechaInicioReserva;   
    private LocalDateTime fechaFinReserva; // Máximo de 3 meses de reserva
    private LocalDateTime fechaCkeckIn;
    private LocalDateTime fechaCheckOut;     
    private double precioTotal;         // Precio total de la reserva (depende del tipo de habitación y número de noches)
}