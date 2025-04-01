package controller;

public class ReservaController {
                                            /*
     *     // Método para agregar una reserva al historial
    public void agregarReserva(String idReserva) {
        if (reservasActivas >= 3) {
            System.out.println("No se pueden agregar más reservas activas.");
            return;
        }

        String reserva = DNI + "," + idReserva;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORIAL_FILE, true))) {
            writer.write(reserva);
            writer.newLine();
            reservasActivas++;
            System.out.println("Reserva agregada al historial.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para leer el historial de reservas
    public void mostrarHistorial() {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(HISTORIAL_FILE));
            System.out.println("Historial de reservas para el cliente con DNI " + DNI + ":");
            for (String linea : lineas) {
                if (linea.startsWith(DNI + ",")) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
                                                             */
}
