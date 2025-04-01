package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import model.Reserva;
import model.Cliente;
import model.Habitacion;


public class ReservaController {
    // Método para agregar una reserva al historial
    public void crearReserva(Cliente cliente, Habitacion habitacion) {
        Reserva reserva = new Reserva(habitacion, cliente, fechaCheckIn, fechaCheckOut); // Instancia de la clase Reserva

        String DNI = reserva.getCliente().getDNI(); // Obtener el DNI del cliente
        int reservasActivas = reserva.getCliente().getReservasActivas(); // Obtener el número de reservas activas del cliente
        String HISTORIAL_FILE = reserva.getCliente().getHistorialFile(); // Obtener la ruta del archivo de historial
        int idReserva = reserva.getIdReserva(); // Obtener el ID de la reserva

        if (reservasActivas >= 3) {
            System.out.println("No se pueden agregar más reservas activas.");
            return;
        }

        String reservaGuardada = DNI + "," + idReserva + "," + numeroHabitacion + "," + fechaCheckIn + "," + fechaCheckOut; // Formato de la reserva a guardar

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORIAL_FILE, true))) {
            writer.write(reservaGuardada);
            writer.newLine();
            reservasActivas++;
            System.out.println("Reserva agregada al historial.");

            
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
/* 
    // Método para leer el historial de reservas
    public void mostrarHistorial() {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(HISTORIAL_FILE));
            System.out.println("Historial de reservas para el cliente con DNI " + DNI + ":");
            for (String linea : lineas) {
                if (linea.startsWith(DNI + ",")) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    */
}
