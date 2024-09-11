package ar.edu.unju.fi.dominio;

import java.util.Objects;

import ar.edu.unju.fi.util.ClaseReserva;
import ar.edu.unju.fi.util.EstadoReserva;

public class Reserva {
    private String origen;
    private String destino;
    private String fechaSalida;
    private String fechaRegreso;
    private ClaseReserva clase;  // Enum para la clase
    private Pasajero pasajero;
    private Pasajero acompaniante; // Puede ser null si no hay acompañante
    private EstadoReserva estado;  // Enum para el estado

    // Constructor para reserva sin acompañante
    public Reserva(String origen, String destino, String fechaSalida, String fechaRegreso, 
                   ClaseReserva clase, Pasajero pasajero) {
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.clase = clase;
        this.pasajero = pasajero;
        this.estado = EstadoReserva.RESERVADA; // Estado inicial: Reservada
        this.acompaniante = null; // No hay acompañante
    }

    // Constructor para reserva con acompañante
    public Reserva(String origen, String destino, String fechaSalida, String fechaRegreso, 
                   ClaseReserva clase, Pasajero pasajero, Pasajero acompaniante) {
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.clase = clase;
        this.pasajero = pasajero;
        this.acompaniante = acompaniante;
        this.estado = EstadoReserva.RESERVADA; // Estado inicial: Reservada
    }

    // Método para cancelar la reserva
    public void cancelarReserva() {
        this.estado = EstadoReserva.CANCELADA;
    }

    // Métodos para obtener la clase de la reserva
    public ClaseReserva getClase() {
        return clase;
    }

    // Método para obtener el estado de la reserva
    public EstadoReserva getEstado() {
        return estado;
    }

    // Otros getters y setters
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Pasajero getAcompaniante() {
        return acompaniante;
    }

    public void setAcompaniante(Pasajero acompaniante) {
        this.acompaniante = acompaniante;
    }

    // Métodos adicionales
    @Override
    public String toString() {
        return "Reserva [origen=" + origen + ", destino=" + destino + ", fechaSalida=" + fechaSalida +
               ", fechaRegreso=" + fechaRegreso + ", clase=" + clase + ", pasajero=" + pasajero +
               ", acompañante=" + (Objects.isNull(acompaniante) ? "Sin acompañante" : acompaniante) +
               ", estado=" + estado + "]";
    }
}
