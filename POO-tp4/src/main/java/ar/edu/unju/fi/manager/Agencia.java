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
    public void registrarReservaSinAcompaniante(String origen, String destino, String fechaSalida, 
                                               String fechaRegreso, ClaseReserva clase, 
                                               Pasajero pasajero) {
        // Validar que el pasajero tenga una contraseña válida
        if (pasajero.validarPassword()) {
            Reserva reserva = new Reserva(origen, destino, fechaSalida, fechaRegreso, clase, pasajero);
            reservas.add(reserva);
            System.out.println("Reserva registrada: " + reserva);
        } else {
            throw new IllegalArgumentException("La contraseña del pasajero no es válida.");
        }
    }

    // Método para registrar una reserva con acompañante
    public void registrarReservaConAcompaniante(String origen, String destino, String fechaSalida, 
                                               String fechaRegreso, ClaseReserva clase, 
                                               Pasajero pasajero, Pasajero acompaniante) {
        // Validar que el pasajero y el acompañante tengan contraseñas válidas (si aplica)
        if (pasajero.validarPassword() && (acompaniante == null || acompaniante.validarPassword())) {
            Reserva reserva = new Reserva(origen, destino, fechaSalida, fechaRegreso, clase, pasajero, acompaniante);
            reservas.add(reserva);
            System.out.println("Reserva registrada con acompañante: " + reserva);
        } else {
            throw new IllegalArgumentException("La contraseña del pasajero o acompañante no es válida.");
        }
    }

    // Método para cancelar una reserva
    public void cancelarReserva(Reserva reserva) {
        reserva.cancelarReserva();
    }

    // Método para obtener reservas por clase
    public List<Reserva> obtenerReservasPorClase(ClaseReserva clase) {
        return reservas.stream()
                       .filter(reserva -> reserva.getClase() == clase)
                       .collect(Collectors.toList());
    }

    // Método para mostrar todas las reservas
    public void mostrarReservas() {
        reservas.forEach(reserva -> System.out.println(reserva));
    }
}