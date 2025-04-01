package view;

import java.util.ArrayList;

import model.Habitacion;
import model.Cliente;

public class Consola {
    // Método para imprimir un mensaje --------------
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

        // Método para mostrar el resumen de las habitaciones
    public void resumenHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        for (Habitacion habitacion : listaHabitaciones) { // Recorremos la lista de habitaciones
            imprimir(
                "Habitación ID: " + habitacion.getNumeroHabitacion() +
                " | Tipo: " + habitacion.getTipo() +
                " | Estado: " + habitacion.getEstado() 
            );
        }
    }

    // Método para mostrar el resumen de los clientes

    public void resumenClientes(ArrayList<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) { // Recorremos la lista de clientes
            imprimir(
                " | Apellido: " + cliente.getNombreCompleto() +
                " | DNI: " + cliente.getDNI() +
                " | Reservas Activas: " + cliente.getReservasActivas()  
            );
        }
    }
}
