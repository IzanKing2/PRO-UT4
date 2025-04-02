package view;

import java.util.ArrayList;

import model.Habitacion;
import model.Cliente;

public class Consola {
    // Método para imprimir un mensaje
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para mostrar el menú principal
    public void mostrarMenuPrincipal() {
        imprimir("______________________________________________");
        imprimir("BIENVENIDO AL SISTEMA DE RESERVAS DEL HOTEL.");
        imprimir("*");
        imprimir("|-1. Mostrar Habitaciones");
        imprimir("|-2. Mostrar Clientes");
        imprimir("|-3. Buscar Habitacion");
        imprimir("|-4. Crear Reserva");
        imprimir("|-5. Consultar Reservas");
        imprimir("|-6. Modificar Reserva");
        imprimir("|-7. Cancelar Reserva");
        imprimir("|-8. Salir");
        imprimir("______________________________________________");
    }

    // Método para mostrar el resumen de las habitaciones
    public void resumenHabitaciones(ArrayList<Habitacion> habitaciones) {
        imprimir("______________________________________________");
        imprimir("HABITACIONES:");
        for (Habitacion habitacion : habitaciones) { // Recorremos la lista de habitaciones
            // Separo las habitaciones por planta con un salto de línea
            if (habitacion.getNumeroHabitacion() % 100 == 1) {
                imprimir(" ");
                imprimir("Planta " + habitacion.getNumeroHabitacion() / 100 + ":");
                imprimir("*");
            }
            imprimir(
                "|- " + habitacion.getNumeroHabitacion() +
                " | Tipo: " + habitacion.getTipoHabitacion() +
                " | Estado: " + habitacion.getEstadoHabitacion() 
            );
        }
        imprimir("______________________________________________");
    }

    // Método para mostrar una habitación por su número
    public void resumenHabitacion(Habitacion habitacion) {
        imprimir("______________________________________________");
        imprimir("HABITACION:");
        imprimir("*");
        imprimir(
            "|- " + habitacion.getNumeroHabitacion() +
            " | Tipo: " + habitacion.getTipoHabitacion() +
            " | Estado: " + habitacion.getEstadoHabitacion() +
            " | Precio: " + habitacion.getPrecioHabitacion() +
            " | Descripción: " + habitacion.getDescripcion()
        );
        imprimir("______________________________________________");
    }

    // Método para mostrar el resumen de los clientes
    public void resumenClientes(ArrayList<Cliente> listaClientes) {
        imprimir("______________________________________________");
        imprimir("CLIENTES:");
        imprimir("*");
        for (Cliente cliente : listaClientes) { // Recorremos la lista de clientes
            imprimir(
                "|- " + cliente.getDNI() +
                " | Nombre: " + cliente.getNombreCompleto() +
                " | Reservas Activas: " + cliente.getReservasActivas()  
            );
        }
        imprimir("______________________________________________");
    }
}
