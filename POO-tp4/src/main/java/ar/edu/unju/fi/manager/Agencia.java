package ar.edu.unju.fi.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ar.edu.unju.fi.dominio.*;
import ar.edu.unju.fi.util.ClaseReserva;

public class Agencia {
    private List<Reserva> reservas;

    public Agencia() {
        this.reservas = new ArrayList<>();
    }

    // Método para registrar una reserva sin acompañante
    public Reserva registrarReservaSinAcompaniante(String origen, String destino, String fechaSalida, 
                                               String fechaRegreso, ClaseReserva clase, 
                                               Pasajero pasajero) {
        // Validar que el pasajero tenga una contraseña válida
        if (pasajero.validarPassword()) {
        	
            Reserva reserva = new Reserva(origen, destino, fechaSalida, fechaRegreso, clase, pasajero);
            reservas.add(reserva);
            return reserva;
        } else {
            throw new IllegalArgumentException("La contraseña del pasajero no es válida.");
        }
    }

    // Método para registrar una reserva con acompañante
    public void registrarReservaConAcompaniante(String origen, String destino, String fechaSalida, 
                                               String fechaRegreso, ClaseReserva clase, 
                                               Pasajero pasajero, Pasajero acompaniante) {
        // Validar que el pasajero tenga una contraseña válida
        if (!pasajero.validarPassword()) {
            throw new IllegalArgumentException("La contraseña del pasajero no es válida.");
        }
        
        
        // Registrar la reserva
        Reserva reserva = new Reserva(origen, destino, fechaSalida, fechaRegreso, clase, pasajero, acompaniante);
        reservas.add(reserva);
       
    }

    /**
     * Cancela una reserva.
     * 
     * @param reserva La reserva a cancelar.
     */
    public void cancelarReserva(Reserva reserva) {
        reserva.cancelarReserva();
    }
    
    
    /**
     * Obtiene las reservas por clase.
     * 
     * @param clase La clase de la reserva (ECONOMY, BUSINESS).
     * @return Una lista de reservas que coinciden con la clase proporcionada.
     */
    public List<Reserva> obtenerReservasPorClase(ClaseReserva clase) {
        return reservas.stream()
                       .filter(reserva -> reserva.getClase() == clase)
                       .collect(Collectors.toList());
    }

    
}