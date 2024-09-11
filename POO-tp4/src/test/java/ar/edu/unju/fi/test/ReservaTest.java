package ar.edu.unju.fi.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.dominio.Pasajero;
import ar.edu.unju.fi.dominio.Reserva;
import ar.edu.unju.fi.manager.Agencia;
import ar.edu.unju.fi.util.ClaseReserva;
import ar.edu.unju.fi.util.EstadoReserva;

class ReservaTest {

    private Agencia agencia;

    @BeforeEach
    public void setUp() {
        agencia = new Agencia(); // Inicializamos la agencia antes de cada test
    }

    @Disabled
    @Test
    @DisplayName("Registrar acompañante de un pasajero")
    public void registrarAcompanianteTest() {
        // Crear pasajeros
        Pasajero pasajero = new Pasajero("Laura", "Marquez", "27665212", "maz_laura@gmail.com", "Passwo1r2d.");
        Pasajero acompaniante = new Pasajero("Carlos", "Perez", "40567234", "carlosPerez@gmail.com", null);

        // Registrar reserva con acompañante
        agencia.registrarReservaConAcompaniante("Buenos Aires", "Madrid", "2024-09-15", "2024-09-30", ClaseReserva.ECONOMY, pasajero, acompaniante);

        // Verificar que la reserva se registró con acompañante
        Reserva reserva = agencia.obtenerReservasPorClase(ClaseReserva.ECONOMY).get(0);
        assertNotNull(reserva.getAcompaniante(), "El acompañante debería haber sido registrado");
        assertEquals(acompaniante, reserva.getAcompaniante(), "El acompañante registrado debería ser Carlos Perez");
    }

    @Test
    @DisplayName("Registro de Reserva sin acompañante")
    public void testRegistrarReservaSinAcompanante() {
        // Crear pasajero
        Pasajero pasajero = new Pasajero("Juan", "Pérez", "12345678", "juan.perez@gmail.com", "Password123!");

        // Registrar reserva sin acompañante
        agencia.registrarReservaSinAcompaniante("Buenos Aires", "Madrid", "2024-12-01", "2024-12-10", ClaseReserva.BUSINESS, pasajero);

        // Verificar que la reserva no tiene acompañante
        Reserva reserva = agencia.obtenerReservasPorClase(ClaseReserva.BUSINESS).get(0);
        assertNull(reserva.getAcompaniante(), "La reserva no debería tener acompañante");
        assertEquals(ClaseReserva.BUSINESS, reserva.getClase(), "La clase debería ser BUSINESS");
        assertEquals(EstadoReserva.RESERVADA, reserva.getEstado(), "El estado debería ser RESERVADA");
    }

    @Test
    @DisplayName("Registro de reserva con acompañante")
    public void registrarReservaConAcompañanteTest() {
        // Crear pasajeros
        Pasajero pasajero = new Pasajero("Juan", "Pérez", "12345678", "juan.perez@gmail.com", "Password123!");
        Pasajero acompaniante = new Pasajero("Pedro", "Picapiedra", "17985621", "pedroPicapiedra@gmail.com", null);

        // Registrar reserva con acompañante
        agencia.registrarReservaConAcompaniante("Buenos Aires", "Madrid", "2024-12-01", "2024-12-10", ClaseReserva.BUSINESS, pasajero, acompaniante);

        // Verificar que la reserva tiene acompañante
        Reserva reserva = agencia.obtenerReservasPorClase(ClaseReserva.BUSINESS).get(0);
        assertNotNull(reserva.getAcompaniante(), "La reserva debería tener un acompañante");
        assertEquals("Pedro", reserva.getAcompaniante().getNombreString(), "El nombre del acompañante debería ser Pedro");
    }

    @Test
    public void testCancelarReserva() {
        // Crear pasajero
        Pasajero pasajero = new Pasajero("Juan", "Pérez", "12345678", "juan.perez@gmail.com", "Password123!");

        // Registrar reserva sin acompañante
        agencia.registrarReservaSinAcompaniante("Buenos Aires", "Madrid", "2024-12-01", "2024-12-10", ClaseReserva.BUSINESS, pasajero);

        // Cancelar la reserva
        Reserva reserva = agencia.obtenerReservasPorClase(ClaseReserva.BUSINESS).get(0);
        assertEquals(EstadoReserva.RESERVADA, reserva.getEstado(), "El estado inicial debería ser RESERVADA");
        agencia.cancelarReserva(reserva);
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado(), "El estado debería ser CANCELADA");
    }

    @Test
    void obtenerReservasPorClaseTest() {
        // Crear pasajeros
        Pasajero pasajero1 = new Pasajero("Victoria", "Martinez", "39665212", "vickMart@gmail.com", "Password123!");
        Pasajero pasajero2 = new Pasajero("Carlos", "Lopez", "40785212", "clopez@gmail.com", "Password456!");

        // Registrar reservas
        agencia.registrarReservaSinAcompaniante("Buenos Aires", "Miami", "2024-09-20", "2024-09-30", ClaseReserva.ECONOMY, pasajero1);
        agencia.registrarReservaSinAcompaniante("Buenos Aires", "New York", "2024-10-01", "2024-10-10", ClaseReserva.BUSINESS, pasajero2);

        // Obtener reservas por clase
        List<Reserva> reservasEconomy = agencia.obtenerReservasPorClase(ClaseReserva.ECONOMY);

        // Verificar que la lista contiene solo una reserva en clase ECONOMY
        assertEquals(1, reservasEconomy.size());
        assertEquals(ClaseReserva.ECONOMY, reservasEconomy.get(0).getClase());
    }
}
