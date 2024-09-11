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
    public void registrarReservaSinAcompañante(String origen, String destino, String fechaSalida, 
                                               String fechaRegreso, ClaseReserva clase, 
                                               Pasajero pasajero) {
        Reserva reserva = new Reserva(origen, destino, fechaSalida, fechaRegreso, clase, pasajero);
        reservas.add(reserva);
        System.out.println("Reserva registrada: " + reserva);
    }

    // Método para registrar una reserva con acompañante
    public void registrarReservaConAcompañante(String origen, String destino, String fechaSalida, 
                                               String fechaRegreso, ClaseReserva clase, 
                                               Pasajero pasajero, Pasajero acompañante) {
        Reserva reserva = new Reserva(origen, destino, fechaSalida, fechaRegreso, clase, pasajero, acompañante);
        reservas.add(reserva);
        System.out.println("Reserva registrada con acompañante: " + reserva);
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