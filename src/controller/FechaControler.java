package controller;

import java.util.List;

import exceptions.FechaNoValidaException;
import model.Cliente;
import model.Reserva;

public class FechaControler {

    public void puedeReservar(Cliente cliente) throws FechaNoValidaException {
        // Verificar si el cliente tiene menos de 3 reservas activas
        if (cliente.getReservasActivas() >= 3) {
            throw new FechaNoValidaException("El cliente ya tiene 3 reservas activas.");
        }
    }

    public void esFechaValida(Reserva reserva) throws FechaNoValidaException {
        if (reserva.getFechaCkeckIn().isBefore(reserva.getFechaInicioReserva())) {
            throw new FechaNoValidaException("La fecha de check-in no puede ser anterior a la fecha de inicio de la reserva.");
        }
    }

    public void esFechaCheckOutValida(Reserva reserva) throws FechaNoValidaException {
        if (reserva.getFechaCheckOut().isBefore(reserva.getFechaCkeckIn())) {
            throw new FechaNoValidaException("La fecha de check-out no puede ser anterior a la fecha de check-in.");
        }
    }
    
    public void hayConflictoDeFechas(Reserva nuevaReserva, List<Reserva> reservasExistentes) throws FechaNoValidaException {
        for (Reserva reserva : reservasExistentes) {
            // Verificar si las fechas de la nueva reserva se solapan con las existentes
            if ((nuevaReserva.getFechaCheckOut().isBefore(reserva.getFechaCkeckIn()))) {
                throw new FechaNoValidaException("Hay un conflicto de fechas con otra reserva existente.");
            }
        }
    }
}


