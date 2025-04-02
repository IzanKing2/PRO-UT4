import controller.ClienteController;
import model.Cliente;
import model.Habitacion;
import controller.HabitacionController;
import view.Consola;
import controller.ReservaController;
import exceptions.ReservaNoDisponibleException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import model.Reserva;


public class App {

    public static void main(String[] args) throws ReservaNoDisponibleException {
        // Inicializar el escáner para la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Instancias de los controladores _____________________________
        ClienteController cliente = new ClienteController();
        HabitacionController habitacion = new HabitacionController();
        ReservaController reserva = new ReservaController();
        Consola consola = new Consola(cliente);
        //______________________________________________________________

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

        int opcion;
        do {
            consola.mostrarMenuPrincipal();
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del escáner
            switch (opcion) {
                case 1: // Mostrar habitaciones __________________________________
                    consola.resumenHabitaciones(habitacion.getHabitaciones());
                    break;
                //________________________________________________________________
                case 2: // Mostrar clientes_______________________________________
                    consola.resumenClientes(cliente.getListaClientes());
                    break;
                //________________________________________________________________
                case 3: // Buscar habitación ___________________________________________________
                    System.out.println("Por que deseo buscar la habitación?");
                    System.out.println("1. Por número de habitación");
                    System.out.println("2. Por tipo de habitación");
                    System.out.println("3. Por estado de habitación");
                    System.out.print("Seleccione una opción: ");
                    int opcionBuscar = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer del escáner

                    switch (opcionBuscar) {
                        case 1: // Buscar por número de habitación _____________________________________________
                            System.out.print("Introduzca el número de habitación: ");
                            int numeroHabitacion = sc.nextInt();
                            try {
                                Habitacion habitacionEncontrada = habitacion.buscarHabitacion(numeroHabitacion);
                                consola.resumenHabitacion(habitacionEncontrada);
                            } catch (exceptions.HabitacionNoEncontradaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        //______________________________________________________________________________________
                        case 2: // Buscar por tipo de habitación ____________________________________________________________
                            System.out.print("Introduzca el tipo de habitación (INDIVIDUAL, DOBLE, SUITE): ");
                            String tipoHabitacionStr = sc.nextLine().toUpperCase();
                            Habitacion.TipoHabitacion tipoHabitacion = Habitacion.TipoHabitacion.valueOf(tipoHabitacionStr);
                            ArrayList<Habitacion> habitacionesPorTipo = habitacion.buscarHabitacion(tipoHabitacion);
                            consola.resumenHabitaciones(habitacionesPorTipo);
                            break;
                        //___________________________________________________________________________________________________
                        case 3: // Buscar por estado de habitación _________________________________________________________________
                            System.out.print("Introduzca el estado de habitación (DISPONIBLE, RESERVADA, OCUPADA): ");
                            String estadoHabitacionStr = sc.nextLine().toUpperCase();
                            Habitacion.EstadoHabitacion estadoHabitacion = Habitacion.EstadoHabitacion.valueOf(estadoHabitacionStr);
                            ArrayList<Habitacion> habitacionesPorEstado = habitacion.buscarHabitacion(estadoHabitacion);
                            consola.resumenHabitaciones(habitacionesPorEstado);
                            break;
                        //__________________________________________________________________________________________________________
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;
                //______________________________________________________________________________________________________________
                case 4: // Crear reserva ________________________________________________________
                    System.out.println("Introduzca el número de habitación: ");
                    Habitacion habitacionDeReserva = null; // Declarar fuera del bloque try
                    Cliente clienteReserva = null; // Declarar fuera del bloque try

                    int numeroHabitacionReserva = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer del escáner

                    try { // Buscar la habitación por su número
                        habitacionDeReserva = habitacion.buscarHabitacion(numeroHabitacionReserva);
                    } catch (exceptions.HabitacionNoEncontradaException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("Introduzca el DNI del cliente: ");
                    String dniCliente = sc.nextLine();
                    
                    try { // Buscar el cliente por su DNI
                        clienteReserva = cliente.buscarCliente(dniCliente);
                    } catch (exceptions.ClienteNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("Introduzca la fecha de check-in (YYYY-MM-DD): ");
                    String fechaCheckInStr = sc.nextLine();
                    System.out.println("Introduzca la fecha de check-out (YYYY-MM-DD): ");
                    String fechaCheckOutStr = sc.nextLine();
                    
                    LocalDateTime fechaCheckIn = LocalDateTime.parse(fechaCheckInStr + "T00:00:00");        // Añadir la hora para evitar el error de formato
                    LocalDateTime fechaCheckOut = LocalDateTime.parse(fechaCheckOutStr + "T00:00:00");      // Añadir la hora para evitar el error de formato

                    reserva.crearReserva(habitacionDeReserva, clienteReserva, fechaCheckIn, fechaCheckOut); // Guardar la reserva en el archivo
                    break;
                //_____________________________________________________________________________________________________________________________________________
                case 5: // Consultar reservas ___________________________________________________
                    System.out.print("Introduzca el DNI del cliente: ");
                    dniCliente = sc.nextLine();
                    Cliente clienteActual = null; // Inicializar clienteActual
                    try {
                        clienteActual = cliente.buscarCliente(dniCliente); // Buscar el cliente por su DNI
                    } catch (exceptions.ClienteNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    ArrayList<Reserva> reservasActivas = reserva.obtenerReservasActivasDeCliente(clienteActual, clienteActual.getReservas()); // Obtener las reservas activas del cliente
                    if (reservasActivas.isEmpty()) {
                        System.out.println("No hay reservas activas para el cliente con DNI: " + dniCliente);
                    } else {
                        consola.getReservasActivas(reservasActivas); // Mostrar las reservas activas del cliente
                    }
                    break;
                //________________________________________________________________________________________________________________________________________________________________________
                case 6: // Mostrar historial de reservas _____________________________________________________________________
                    System.out.println("Introduzca el DNI del cliente: ");
                    dniCliente = sc.nextLine();

                    consola.getHistorialReservas(dniCliente);             // Mostrar el historial de reservas del cliente
                    break;
                //_____________________________________________________________________________________________________________
                case 7: // Cancelar reserva ___________________________________________________
                    System.out.println("Introduzca el DNI del cliente: ");
                    dniCliente = sc.nextLine();
                    Cliente clienteCancelacion = null; // Inicializar clienteCancelacion

                    try {
                        clienteCancelacion = cliente.buscarCliente(dniCliente); // Inicializar clienteCancelacion
                    } catch (exceptions.ClienteNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("Introduzca el id de la reserva: ");
                    int idReserva = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer del escáner
                    ArrayList<Reserva> reservaActual = reserva.obtenerReservasActivasDeCliente(clienteCancelacion, clienteCancelacion.getReservas()); // Obtener las reservas activas del cliente
                    Reserva reservaACancelar = reserva.seleccionarReservaPorId(idReserva, reservaActual); // Seleccionar la reserva por su ID
                    reserva.cancelarReserva(reservaACancelar); // Cancelar la reserva
                    clienteCancelacion.getReservas().remove(reservaACancelar); // Eliminar la reserva de la lista de reservas del cliente
                    System.out.println("Reserva cancelada con éxito.");
                    break;
                //________________________________________________________________________________________________________________________________________________________________________
                case 8: // Salir ______________________________________________________
                    System.out.println("Saliendo del programa...");
                    break;
                //____________________________________________________________________
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);
        sc.close(); // Cerrar el escáner al finalizar
    } 
}