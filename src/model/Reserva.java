package model;

import java.time.LocalDateTime;

public class Reserva {
    // Atributos estáticos
    private static int contadorIdReservas = 0; // Contador de reservas (se puede mejorar con un generador de ID único)

    // Atributos
    private int idReserva; // ID de la reserva (se genera automáticamente)
    private Habitacion habitacion;
    private Cliente cliente;            // Cliente que realiza la reserva
    private LocalDateTime fechaInicioReserva;   
    private LocalDateTime fechaFinReserva; // Máximo de 3 meses de reserva
    private LocalDateTime fechaCkeckIn;
    private LocalDateTime fechaCheckOut;     
    private double precioTotal;         // Precio total de la reserva (depende del tipo de habitación y número de noches)


    public Reserva(Habitacion habitacion, Cliente cliente, LocalDateTime fechaCheckIn, LocalDateTime fechaCheckOut) {
        this.idReserva = ++contadorIdReservas; // Incrementar el ID de la reserva (se puede mejorar con un generador de ID único)
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaInicioReserva = LocalDateTime.now(); // Fecha y hora de la reserva
        this.fechaFinReserva = fechaInicioReserva.plusMonths(3); // Máximo de 3 meses de reserva
        this.fechaCkeckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.precioTotal = 0; // Inicialmente 0, se calculará al finalizar la reserva
    }

    // Getters
    public int getIdReserva() {
        return this.idReserva;
    }

    public Habitacion getHabitacion() {
        return this.habitacion;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public LocalDateTime getFechaInicioReserva() {
        return this.fechaInicioReserva;
    }

    public LocalDateTime getFechaFinReserva() {
        return this.fechaFinReserva;
    }

    public LocalDateTime getFechaCkeckIn() {
        return this.fechaCkeckIn;
    }

    public LocalDateTime getFechaCheckOut() {
        return this.fechaCheckOut;
    }

    public double getPrecioTotal() {
        return this.precioTotal;
    }


    // Setters
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}