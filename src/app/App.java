

import controller.ClienteController;
import model.Cliente;
import model.Habitacion;
import controller.HabitacionController;
import view.Consola;
import controller.ReservaController;
import exceptions.ReservaNoDisponibleException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws ReservaNoDisponibleException {
        // Inicializar el escáner para la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Instancias de los controladores
        ClienteController cliente = new ClienteController();
        HabitacionController habitacion = new HabitacionController();
        ReservaController reserva = new ReservaController();
        Consola consola = new Consola();

        // Habitaciones _____________________________________________________________________________________________________________
        // Habitaciones planta 1
        Habitacion habitacion101 = new Habitacion(101, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion102 = new Habitacion(102, Habitacion.TipoHabitacion.DOBLE, 80.0);
        Habitacion habitacion103 = new Habitacion(103, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion104 = new Habitacion(104, Habitacion.TipoHabitacion.DOBLE, 80.0);
        Habitacion habitacion105 = new Habitacion(105, Habitacion.TipoHabitacion.DOBLE, 80.0);

        // Habitaciones planta 2
        Habitacion habitacion201 = new Habitacion(201, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion202 = new Habitacion(202, Habitacion.TipoHabitacion.DOBLE, 80.0);
        Habitacion habitacion203 = new Habitacion(203, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion204 = new Habitacion(204, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion205 = new Habitacion(205, Habitacion.TipoHabitacion.DOBLE, 80.0);

        // Habitaciones planta 3
        Habitacion habitacion301 = new Habitacion(301, Habitacion.TipoHabitacion.INDIVIDUAL, 50.0);
        Habitacion habitacion302 = new Habitacion(302, Habitacion.TipoHabitacion.DOBLE, 80.0);
        Habitacion habitacion303 = new Habitacion(303, Habitacion.TipoHabitacion.SUITE, 150.0);
        Habitacion habitacion304 = new Habitacion(304, Habitacion.TipoHabitacion.SUITE, 150.0);
        Habitacion habitacion305 = new Habitacion(305, Habitacion.TipoHabitacion.SUITE, 150.0);

        // Añadir habitaciones a la lista de habitaciones
        habitacion.añadirHabitacion(habitacion101);
        habitacion.añadirHabitacion(habitacion102);
        habitacion.añadirHabitacion(habitacion103);
        habitacion.añadirHabitacion(habitacion104);
        habitacion.añadirHabitacion(habitacion105);
        habitacion.añadirHabitacion(habitacion201);
        habitacion.añadirHabitacion(habitacion202);
        habitacion.añadirHabitacion(habitacion203);
        habitacion.añadirHabitacion(habitacion204);
        habitacion.añadirHabitacion(habitacion205);
        habitacion.añadirHabitacion(habitacion301);
        habitacion.añadirHabitacion(habitacion302);
        habitacion.añadirHabitacion(habitacion303);
        habitacion.añadirHabitacion(habitacion304);
        habitacion.añadirHabitacion(habitacion305);
        //____________________________________________________________________________________________________________________________

        // Clientes ___________________________________________________________________________________
        Cliente cliente1 = new Cliente("54163650F", "Izan Carlo Celis Afonso");
        Cliente cliente2 = new Cliente("54163651P", "Naia Celis Afonso");
        Cliente cliente3 = new Cliente("54163652G", "Pablo Garcia Castellano");
        Cliente cliente4 = new Cliente("54163653D", "Javier Garcia Castellano");

        // Añadir clientes a la lista de clientes
        cliente.añadirCliente(cliente1);
        cliente.añadirCliente(cliente2);
        cliente.añadirCliente(cliente3);
        cliente.añadirCliente(cliente4);
        //_____________________________________________________________________________________________
        
        // Reservas
        reserva.crearReserva(habitacion305, cliente4, null, null);

        int opcion;
        do {
            consola.mostrarMenuPrincipal();
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    consola.resumenHabitaciones(habitacion.getHabitaciones());
                    break;
                case 2:
                    consola.resumenClientes(cliente.getListaClientes());
                    break;
                case 3:
                    // Crear reserva
                    break;
                case 4:
                    // Consultar reservas
                    break;
                case 5:
                    // Modificar reserva
                    break;
                case 6:
                    // Cancelar reserva
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);
    }
}