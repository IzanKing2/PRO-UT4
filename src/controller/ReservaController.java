package controller;

import model.Reserva;
import model.Habitacion;
import model.Cliente;
import exceptions.ReservaNoDisponibleException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class ReservaController {
    
    public void crearReserva(Habitacion habitacion, Cliente cliente, LocalDateTime fechaCheckIn, LocalDateTime fechaCheckOut) throws ReservaNoDisponibleException {
        // Verificar si el cliente tiene menos de 3 reservas activas
        if (cliente.getReservasActivas() >= 3) {
            throw new ReservaNoDisponibleException("El cliente ya tiene 3 reservas activas.");
        } else {
            // Crear la reserva
            Reserva reserva = new Reserva(habitacion, cliente, fechaCheckIn, fechaCheckOut);
            
            // Incrementar el contador de reservas activas del cliente
            cliente.setReservasActivas(1);
            
            // Guardar la reserva en un archivo
            guardarReserva(reserva);
        }
    }

    public void guardarReserva(Reserva reserva) {
        // Nombre del archivo donde se guardarán las reservas
        String archivoReservas = "reservas.txt";

        // Formato de la reserva para guardar en el archivo
        String reservaTexto = "Usuario: " + reserva.getCliente().getDNI() + " // ID:" +
            reserva.getIdReserva() + " // Fechas: " + // Id de la reserva
            reserva.getFechaCkeckIn() + " - " +
            reserva.getFechaCheckOut() + " // Precio Total:" +  
            reserva.getPrecioTotal();

        // Escribir la reserva en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoReservas, true))) {
            writer.write(reservaTexto);
            writer.newLine(); // Agregar una nueva línea después de cada reserva
            System.out.println("Reserva guardada en el archivo: " + archivoReservas);
        } catch (IOException e) {
            System.err.println("Error al guardar la reserva en el archivo: " + e.getMessage());
        }
    }

    public void calcularPrecioTotal(Habitacion habitacion, Reserva reserva) {
        // Calcular el precio total de la reserva
        double precioTotal = habitacion.getPrecioHabitacion() * (Duration.between(reserva.getFechaCkeckIn(), reserva.getFechaCheckOut()).toDays());
        reserva.setPrecioTotal(precioTotal);
    }

    public void cancelarReserva(Reserva reserva) throws ReservaNoDisponibleException {
        // Verificar si la fecha de check-in ya ha comenzado
        if (reserva.getFechaCkeckIn().isBefore(reserva.getFechaInicioReserva())) {
            throw new ReservaNoDisponibleException("La reserva no puede ser cancelada porque la fecha de check-in ya ha comenzado.");
        }
    
        // Cambiar el estado de la habitación a DISPONIBLE
        reserva.getHabitacion().setEstadoHabitacion(Habitacion.EstadoHabitacion.DISPONIBLE);
    
        // Decrementar el contador de reservas activas del cliente
        reserva.getCliente().setReservasActivas(reserva.getCliente().getReservasActivas() - 1);
    
        // Mensaje de confirmación
        System.out.println("Reserva cancelada: ID " + reserva.getIdReserva() + ". La habitación ahora está disponible.");
    }

    public List<Reserva> obtenerReservasActivasDeCliente(Cliente cliente, List<Reserva> reservas) {
        List<Reserva> reservasActivas = new ArrayList<>();

        // Recorrer la lista de reservas
        for (Reserva reserva : reservas) {
            // Verificar si la reserva pertenece al cliente y está activa
            if (reserva.getCliente().equals(cliente) && 
                reserva.getHabitacion().getEstadoHabitacion() == Habitacion.EstadoHabitacion.RESERVADA) {
                reservasActivas.add(reserva); // Agregar a la lista de reservas activas
            }
        }
        return reservasActivas; // Retornar la lista de reservas activas
    }
}
