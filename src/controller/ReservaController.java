package controller;

import model.Cliente;
import model.Habitacion;
import model.Reserva;
import exceptions.ReservaNoDisponibleException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;

public class ReservaController {
    public Reserva crearReserva(Habitacion habitacion, Cliente cliente, LocalDateTime fechaCheckIn, LocalDateTime fechaCheckOut) throws ReservaNoDisponibleException {
        // Verificar si el cliente tiene menos de 3 reservas activas
        if (cliente.getReservasActivas() >= 3) {
            throw new ReservaNoDisponibleException("El cliente ya tiene 3 reservas activas.");
        } else {
            // Crear la reserva
            Reserva reserva = new Reserva(habitacion, cliente, fechaCheckIn, fechaCheckOut);
            // Incrementar el contador de reservas activas del cliente
            cliente.setReservasActivas(1);
            // Calcular el precio total de la reserva
            calcularPrecioTotal(habitacion, reserva);

            // Guardar la reserva en el archivo
            guardarReserva(reserva);

            return reserva; // Retornar la reserva creada
        }
    }

    public void guardarReserva(Reserva reserva) {
        // Obtener la carpeta del cliente basada en su DNI
        String carpetaCliente = "clientes/" + reserva.getCliente().getDNI();
        File directorioCliente = new File(carpetaCliente);

        // Verificar si la carpeta del cliente existe, si no, crearla
        if (!directorioCliente.exists()) {
            directorioCliente.mkdirs();
        }

        // Ruta del archivo historial del cliente
        String archivoHistorial = carpetaCliente + "/historial.txt";

        // Formato de la reserva para guardar en el archivo
        String reservaTexto = "ID Reserva: " + reserva.getIdReserva() +
            " | Fechas: " + reserva.getFechaCkeckIn() + " - " + reserva.getFechaCheckOut() +
            " | Habitacion: " + reserva.getHabitacion().getNumeroHabitacion() +
            " | Precio Total: " + reserva.getPrecioTotal();

        // Escribir la reserva en el archivo historial del cliente
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoHistorial, true))) {
            writer.write(reservaTexto);
            writer.newLine(); // Agregar una nueva línea después de cada reserva
            System.out.println("Reserva guardada en el archivo del cliente: " + archivoHistorial);
        } catch (IOException e) {
            System.err.println("Error al guardar la reserva en el archivo del cliente: " + e.getMessage());
        }
    }

    public void calcularPrecioTotal(Habitacion habitacion, Reserva reserva) {
        // Calcular el precio total de la reserva
        double precioTotal = habitacion.getPrecioHabitacion() * (Duration.between(reserva.getFechaCkeckIn(), reserva.getFechaCheckOut()).toDays());
        reserva.setPrecioTotal(precioTotal);
    }
}
