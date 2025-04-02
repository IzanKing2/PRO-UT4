package controller;

import java.util.ArrayList;

import exceptions.ClienteNoEncontradoException;
import model.Cliente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

        // Crear carpeta para el cliente
        String carpetaCliente = "clientes/" + cliente.getDNI(); // Carpeta basada en el DNI del cliente
        File directorioCliente = new File(carpetaCliente);
        if (!directorioCliente.exists()) {
            directorioCliente.mkdirs(); // Crear la carpeta si no existe
        }

        // Crear el archivo de historial de reservas dentro de la carpeta del cliente
        String archivoHistorial = carpetaCliente + "/historial.txt";
        try {
            FileWriter fileWriter = new FileWriter(archivoHistorial, true); // true para añadir al archivo existente
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Historial de reservas del cliente: " + cliente.getNombreCompleto());
            bufferedWriter.newLine(); // Nueva línea después del encabezado
            bufferedWriter.close(); // Cerrar el BufferedWriter
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de historial: " + e.getMessage());
        }
    }

    // Método para buscar un cliente por su DNI
    public Cliente buscarCliente(String dni) throws ClienteNoEncontradoException {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDNI().equalsIgnoreCase(dni)) {
                return cliente; // Retornar el cliente encontrado
            }
        }
        throw new ClienteNoEncontradoException("Cliente no encontrado: " + dni); // Lanzar excepción si no se encuentra el cliente
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
