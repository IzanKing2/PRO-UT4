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

    // Getters
    public ArrayList<Cliente> getListaClientes() {
        return this.listaClientes;
    }
}
