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

    // Constructores
    public Habitacion(int numeroHabitacion, TipoHabitacion tipoHabitacion, double precioHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.estadoHabitacion = EstadoHabitacion.DISPONIBLE;
        this.precioHabitacion = precioHabitacion;
    }

    public Habitacion(int numeroHabitacion, TipoHabitacion tipoHabitacion, double precioHabitacion, String descripcion) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.estadoHabitacion = EstadoHabitacion.DISPONIBLE;
        this.descripcion = descripcion;
    }

    // Getters
    public int getNumeroHabitacion() {
        return this.numeroHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return this.tipoHabitacion;
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return this.estadoHabitacion;
    }

    public double getPrecioHabitacion() {
        return this.precioHabitacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    // Setters
    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
}