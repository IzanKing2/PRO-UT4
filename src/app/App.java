import controller.ClienteController;
import model.Cliente;
import controller.ReservaController;
import java.time.LocalDateTime;


public class App {

    public static void main(String[] args) {
        // Instancias de los controladores
        ClienteController cliente = new ClienteController();
        ReservaController reserva = new ReservaController();

        // Crear un cliente con DNI y nombre completo
        Cliente clente1 = new Cliente("54163650F", "Izan Carlo Celis Afonso");
        // Crear una reserva para el cliente
        reserva.agregarReserva(101, clente1, LocalDateTime.now(), LocalDateTime.now().plusDays(3));
        reserva.agregarReserva(104, clente1, LocalDateTime.now(), LocalDateTime.now().plusDays(10));

    }
}