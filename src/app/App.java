package app;

import controller.ClienteController;
import model.Cliente;
import model.Habitacion;
import view.Consola;
import controller.ReservaController;
import java.time.LocalDateTime;


public class App {

    public static void main(String[] args) {
        // Instancias de los controladores
        ClienteController cliente = new ClienteController();
        ReservaController reserva = new ReservaController();

        // Habitaciones planta 1
        Habitacion habitacion11 = new Habitacion(101, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion12 = new Habitacion(102, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion13 = new Habitacion(103, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion14 = new Habitacion(104, Habitacion.TipoHabitacion.DOBLE, 80.0);
        Habitacion habitacion15 = new Habitacion(105, Habitacion.TipoHabitacion.DOBLE, 80.0);

        // Habitaciones planta 2
        Habitacion habitacion21 = new Habitacion(201, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion22 = new Habitacion(202, Habitacion.TipoHabitacion.DOBLE, 80.0);
        Habitacion habitacion23 = new Habitacion(203, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion24 = new Habitacion(204, Habitacion.TipoHabitacion.DOBLE, 80.0);
        Habitacion habitacion25 = new Habitacion(205, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);

        // Habitaciones planta 3
        Habitacion habitacion31 = new Habitacion(301, Habitacion.TipoHabitacion.SUITE, 150.0);
        Habitacion habitacion32 = new Habitacion(302, Habitacion.TipoHabitacion.SUITE, 150.0);
        Habitacion habitacion33 = new Habitacion(303, Habitacion.TipoHabitacion.SUITE, 150.0);
        Habitacion habitacion34 = new Habitacion(304, Habitacion.TipoHabitacion.SUITE, 150.0);
        Habitacion habitacion35 = new Habitacion(305, Habitacion.TipoHabitacion.SUITE, 150.0);

        // Clientes
        Cliente clente1 = new Cliente("54163650F", "Izan Carlo Celis Afonso");
        Cliente clente2 = new Cliente("60700411F", "Diego Lázaro Cádiz Torres");
        Cliente cliente3 = new Cliente("12345678A", "Juan Pérez García");
        Cliente cliente4 = new Cliente("42270855M", "Saul Espino Santana");
        Cliente cliente5 = new Cliente("23456789C", "Ana Sánchez Martínez");

        // Crear una reserva para el cliente
        
        // Listar habitaciones y su esado

        Consola.imprimir(null);


    }
}