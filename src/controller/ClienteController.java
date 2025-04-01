package controller;

import java.io.File;
import model.Cliente;

// Excepción personalizada para errores de validación de DNI
class DNIException extends Exception {
    public DNIException(String mensaje) {
        super(mensaje);
    }
}

public class ClienteController {

    // Letra del DNI español
    // La letra se calcula con el resto de la división del número entre 23
    private static final char[] letrasDni = 
        {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};


    // Verifica si el DNI es correcto
    // El formato del DNI es 8 dígitos seguidos de una letra (Ej: 12345678Z)
    public boolean verificarDNI(String dni) throws DNIException {
        // Verificar si el formato es correcto
        if (dni == null || !dni.matches("\\d{8}[A-Z]")) {
            throw new DNIException("Formato incorrecto. Debe tener 8 números y 1 letra (Ej: 12345678Z).");
        }

        // Extraer número y letra
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letraCalculada = letrasDni[numero % 23]; // Calcular la letra
        char letraDNI = dni.charAt(8);

        // Si la letra no coincide, lanzamos una excepción
        if (letraCalculada != letraDNI) {
            throw new DNIException("Letra incorrecta. La letra correcta para " + numero + " es '" + letraCalculada + "'.");
        }

        return true;
    }

    // Crear un cliente
    public void crearCliente(String DNI, String nombreCompleto) {
        try {
            verificarDNI(DNI); // Verificamos el DNI

            // Aquí se crea la carpeta con el dni y se guarda el cliente
            Cliente cliente = new Cliente(DNI, nombreCompleto);             // Crear el cliente
            File userFolder = new File("clientes/" + DNI);       // Crear la carpeta del usuario
            if (!userFolder.exists()) {
                userFolder.mkdirs();
            }
        } catch (DNIException e) {
            System.out.println("Error con DNI " + DNI + ": " + e.getMessage());
            return; // Salimos si el DNI no es válido
        }
    }
}
