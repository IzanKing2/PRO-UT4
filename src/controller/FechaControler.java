package controller;

import java.util.List;

import model.Cliente;
import model.Reserva;

public class FechaControler {

    public boolean puedeReservar(Cliente cliente) {
        // Verificar si el cliente tiene menos de 3 reservas activas
        if (cliente.getReservasActivas() >= 3) {
            return false; // El cliente no puede reservar más
        } else {
            return true; // El cliente puede reservar
        }
    }

    public boolean esFechaValida(Reserva reserva) {
        if (reserva.getFechaCkeckIn().isBefore(reserva.getFechaInicioReserva())) {
            return false; // La fecha de check-in no puede ser anterior a la fecha actual
        } else {
            return true; // La fecha de check-in es válida
        }
    }

    public boolean esFechaCheckOutValida(Reserva reserva) {
        if (reserva.getFechaCheckOut().isBefore(reserva.getFechaCkeckIn())) {
            return false; // La fecha de check-out no puede ser anterior al check-in
        } else {
            return true; // La fecha de check-out es válida
        }
    }
    
    public boolean hayConflictoDeFechas(Reserva nuevaReserva, List<Reserva> reservasExistentes) {
        for (Reserva reserva : reservasExistentes) {
            // Verificar si las fechas de la nueva reserva se solapan con las existentes
            if (!(nuevaReserva.getFechaCheckOut().isBefore(reserva.getFechaCkeckIn()) ||
                nuevaReserva.getFechaCkeckIn().isAfter(reserva.getFechaCheckOut()))) {
                return true; // Hay un conflicto de fechas
            }
        }
        return false; // No hay conflictos de fechas
    }
}


