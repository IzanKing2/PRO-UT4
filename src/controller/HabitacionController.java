package controller;

import model.Habitacion;

import java.util.ArrayList;

import exceptions.HabitacionNoEncontradaException;

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

    // Método para buscar una habitación por su número
    public Habitacion buscarHabitacion(int numeroHabitacion) throws HabitacionNoEncontradaException {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                return habitacion;
            }
        }
        throw new HabitacionNoEncontradaException("Habitación no encontrada: " + numeroHabitacion);
    }

    // Método para buscar habitaciones por tipo usando sobrecarga de método
    public ArrayList<Habitacion> buscarHabitacion(Habitacion.TipoHabitacion tipoHabitacion) {
        ArrayList<Habitacion> habitacionesEncontradas = new ArrayList<Habitacion>();

        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getTipoHabitacion() == tipoHabitacion) {
                habitacionesEncontradas.add(habitacion);
            }
        }
        return habitacionesEncontradas; // Se devuelve la lista de habitaciones encontradas
    }

    // Método para buscar habitaciones por estado usando sobrecarga de método
    public ArrayList<Habitacion> buscarHabitacion(Habitacion.EstadoHabitacion estadoHabitacion) {
        ArrayList<Habitacion> habitacionesEncontradas = new ArrayList<Habitacion>();

        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getEstadoHabitacion() == estadoHabitacion) {
                habitacionesEncontradas.add(habitacion);
            }
        }
        return habitacionesEncontradas; // Se devuelve la lista de habitaciones encontradas
    }

    // Getters
    public ArrayList<Habitacion> getHabitaciones() {
        return this.habitaciones;
    }
}
