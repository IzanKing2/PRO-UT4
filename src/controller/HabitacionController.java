package controller;

import model.Habitacion;
import java.util.ArrayList;

public class HabitacionController {
    // atributos
    private ArrayList<Habitacion> habitaciones;

    // Constructor
    public HabitacionController() {
        // Inicializar la lista de habitaciones
        this.habitaciones = new ArrayList<Habitacion>();
    }

    // Método para añadir una habitación a la lista
    public void añadirHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    // Getters
    public ArrayList<Habitacion> getHabitaciones() {
        return this.habitaciones;
    }
}
