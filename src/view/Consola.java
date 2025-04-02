package view;

import java.util.ArrayList;

import controller.ClienteController;
import exceptions.ClienteNoEncontradoException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.Habitacion;
import model.Cliente;
import model.Reserva;

public class Consola {
    // Atributos
    private ClienteController cliente; // Controlador de clientes

    // Constructor
    public Consola(ClienteController cliente) {
        this.cliente = cliente; // Inicializar el controlador de clientes
    }

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
        imprimir("|-6. Mostrar Historial de Reservas");
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

    // Método para mostrar las reservas de un cliente
    public void getHistorialReservas(String dni) {
        Cliente clienteActual = null; // Inicializar clienteActual

        try {
            // Buscar el cliente por su DNI
            clienteActual = cliente.buscarCliente(dni); // Llamar al método para buscar el cliente por su DNI
        } catch (ClienteNoEncontradoException e) {
            imprimir("Error: " + e.getMessage()); // Imprimir mensaje de error si no se encuentra el cliente
            return; // Salir del método si el cliente no se encuentra
        }
        imprimir("______________________________________________");
        imprimir("RESERVAS DEL CLIENTE: " + clienteActual.getNombreCompleto());
        imprimir("*");

        // Ruta del archivo historial del cliente
        String archivoHistorial = "clientes/" + clienteActual.getDNI() + "/historial.txt";
        File archivo = new File(archivoHistorial);

        // Verificar si el archivo existe
        if (!archivo.exists()) {
            imprimir("|- No hay historial de reservas para este cliente.");
        } else {
            // Leer el contenido del archivo y mostrarlo
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    imprimir(linea); // Imprimir cada línea del archivo
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo de historial: " + e.getMessage());
            }
        }

        imprimir("______________________________________________");
    }

    // Método para mostrar las reservas activas de un cliente
    public void getReservasActivas(ArrayList<Reserva> reservasActivas) {
        imprimir("______________________________________________");
        imprimir("RESERVAS ACTIVAS:");
        imprimir("*");
        for (Reserva reserva : reservasActivas) { // Recorremos la lista de reservas activas
            imprimir(
                "|- ID Reserva: " + reserva.getIdReserva() +
                " | Habitacion: " + reserva.getHabitacion().getNumeroHabitacion() +
                " | Cliente: " + reserva.getCliente().getNombreCompleto() +
                " | Fechas: " + reserva.getFechaCkeckIn() + " - " + reserva.getFechaCheckOut()
            );
        }
        imprimir("______________________________________________");
    }
}
