package model;

public class Habitacion {
    // ENUM: Tipos de Habitacion y Estado de Habitacion
    public enum TipoHabitacion {
        INDIVIDUAL,
        DOBLE,
        SUITE
    }

    public enum EstadoHabitacion {
        DISPONIBLE,
        RESERVADA,
        OCUPADA
    }

    // Atributos
    private int numeroHabitacion;               // Número de la habitación ÚNICO
    private TipoHabitacion tipoHabitacion;      // Tipo de habitación (individual, doble, suite)
    private EstadoHabitacion estadoHabitacion;  // Estado de la habitación (disponible, reservada, ocupada)
    private double precioHabitacion;            // Precio por noche(depende del tipo de habitación)
    private String descripcion;                 // Descripción de la habitación(opcional)
    private int[][] habitaciones = {            // Numero de habitaciones
        {101, 102, 103, 104, 105},
        {201, 202, 203, 204, 205},
        {301, 302, 303, 304, 305},
    };

    // Constructores
    public Habitacion() {
    }
}