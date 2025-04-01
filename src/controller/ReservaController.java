package controller;

import model.Habitacion;
import model.Cliente;
import exceptions.ReservaNoDisponibleException;
import java.time.LocalDateTime;
import model.Reserva;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
}
