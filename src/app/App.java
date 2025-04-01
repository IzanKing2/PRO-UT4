import controller.ClienteController;
import model.Cliente;

public class App {

    public static void main(String[] args) {
        // Instancias de los controladores
        ClienteController cliente = new ClienteController();

        // Crear un cliente con DNI y nombre completo
        cliente.crearCliente("54163650F", "Izan Carlo Celis Afonso");
    }
}