package controller;

import java.util.ArrayList;
import model.Cliente;

public class ClienteController {
    // Atributos
    private final String dniChars="TRWAGMYFPDXBNJZSQVHLCKE"; // Caracteres de control del DNI
    private ArrayList<Cliente> listaClientes; // Lista de clientes

    // Constructor
    public ClienteController() {
        // Inicializar la lista de clientes
        this.listaClientes = new ArrayList<Cliente>();
    }

    // Método para añadir un cliente a la lista
    public void añadirCliente(Cliente cliente) {
            // Añadir el cliente a la lista
            listaClientes.add(cliente);
    }

    // Verificar si el DNI es válido (opcional)
    public boolean validarDNI(String dni) {
        // Comprobar si el DNI tiene 9 caracteres y el último es una letra
        if (dni.length() != 9 || !Character.isLetter(dni.charAt(8))) {
            return false; // DNI no válido
        }
        String intPartDNI = dni.trim().replaceAll(" ", "").substring(0, 7);
        char ltrDNI = dni.charAt(8);
        int valNumDni = Integer.parseInt(intPartDNI) % 23;
        if (dni.length()!= 9 && isNumeric(intPartDNI) == false && dniChars.charAt(valNumDni)!= ltrDNI) {
            return false;
        } else {
            return true;
        }
    }

    // Método para verificar si una cadena es numérica
    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Getters
    public ArrayList<Cliente> getListaClientes() {
        return this.listaClientes;
    }
}
