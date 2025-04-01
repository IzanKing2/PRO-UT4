package model;

import java.time.LocalDateTime;

public class Reserva {

    // Atributos
    private int idReserva;
    private int numeroHabitacion;
    private Cliente cliente;            // Cliente que realiza la reserva
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;     // Máximo de 3 meses de reserva
    private double precioTotal;         // Precio total de la reserva (depende del tipo de habitación y número de noches)
}