package ar.edu.unju.fi.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.dominio.Pasajero;
import ar.edu.unju.fi.dominio.Reserva;
import ar.edu.unju.fi.manager.Agencia;
import ar.edu.unju.fi.util.ClaseReserva;
import ar.edu.unju.fi.util.EstadoReserva;

/**
 * Clase de prueba para la clase {@link Reserva}.
 * 
 * Contiene tests para verificar el registro de reservas, tanto con como sin acompañante, así como la cancelación
 * de reservas y la obtención de reservas por clase.
 */
class ReservaTest {

    private Agencia agencia;

    /**
     * Configuración inicial antes de cada prueba.
     * 
     * Se inicializa una nueva instancia de {@link Agencia} para asegurar que cada prueba comience con un estado limpio.
     */
    @BeforeEach
    public void setUp() {
        agencia = new Agencia(); // Inicializamos la agencia antes de cada test
    }

    /**
     * Prueba para registrar un acompañante en una reserva.
     * 
     * Se crea un pasajero y un acompañante, y se registra una reserva con el acompañante. Se verifica que la
     * reserva tenga el acompañante registrado correctamente.
     */
    
    
    @Test
    @DisplayName("Registrar acompañante de un pasajero")
    public void registrarAcompanianteTest() {
        // Crear pasajeros con contraseñas válidas
        Pasajero pasajero = new Pasajero("Laura", "Marquez", "27665212", "maz_laura@gmail.com", "Passwo1r2d.");
        Pasajero acompaniante = new Pasajero("Carlos", "Perez", "40567234", "carlosPerez@gmail.com", null);

        // Registrar reserva con acompañante
        agencia.registrarReservaConAcompaniante("Buenos Aires", "Madrid", "2024-09-15", "2024-09-30", ClaseReserva.ECONOMY, pasajero, acompaniante);

        // Verificar que la reserva se registró con acompañante
        Reserva reserva = agencia.obtenerReservasPorClase(ClaseReserva.ECONOMY).get(0);
        assertNotNull(reserva.getAcompaniante(), "El acompañante debería haber sido registrado");
        assertEquals(acompaniante, reserva.getAcompaniante(), "El acompañante registrado debería ser Carlos Perez");
    }

    
    /**
     * Prueba para registrar una reserva sin acompañante.
     * 
     * Se crea un pasajero con una contraseña válida y se registra una reserva sin acompañante. Se verifica que la
     * reserva no tenga acompañante y que los demás atributos se establezcan correctamente.
     */
    @Test
    @DisplayName("Registro de Reserva sin acompañante")
    public void testRegistrarReservaSinAcompanante() {
        // Crear pasajero con contraseña válida
        Pasajero pasajero = new Pasajero("Juan", "Pérez", "12345678", "juan.perez@gmail.com", "Pass0word1!");

        // Registrar reserva sin acompañante
        Reserva reserva = agencia.registrarReservaSinAcompaniante("Buenos Aires", "Madrid", "2024-12-01", "2024-12-10", ClaseReserva.BUSINESS, pasajero);

        // Verificar que la reserva no tiene acompañante
        assertNull(reserva.getAcompaniante(), "La reserva no debería tener acompañante");
        assertEquals(ClaseReserva.BUSINESS, reserva.getClase(), "La clase debería ser BUSINESS");
        assertEquals(EstadoReserva.RESERVADA, reserva.getEstado(), "El estado debería ser RESERVADA");
    }

    
    /**
     * Prueba para registrar una reserva con acompañante.
     * 
     * Se crea un pasajero y un acompañante, y se registra una reserva con el acompañante. Se verifica que la
     * reserva tenga el acompañante registrado correctamente.
     */
    @Test
    @DisplayName("Registro de reserva con acompañante")
    public void registrarReservaConAcompañanteTest() {
        // Crear pasajeros
        Pasajero pasajero = new Pasajero("Juan", "Pérez", "12345678", "juan.perez@gmail.com", "P7assword1!");
        Pasajero acompaniante = new Pasajero("Pedro", "Picapiedra", "17985621", "pedroPicapiedra@gmail.com", null);

        // Registrar reserva con acompañante
        agencia.registrarReservaConAcompaniante("Buenos Aires", "Madrid", "2024-12-01", "2024-12-10", ClaseReserva.BUSINESS, pasajero, acompaniante);

        // Verificar que la reserva tiene acompañante
        Reserva reserva = agencia.obtenerReservasPorClase(ClaseReserva.BUSINESS).get(0);
        assertNotNull(reserva.getAcompaniante(), "La reserva debería tener un acompañante");
        assertEquals("Pedro", reserva.getAcompaniante().getNombre(), "El nombre del acompañante debería ser Pedro");
    }

    
    /**
     * Prueba para cancelar una reserva.
     * 
     * Se crea un pasajero, se registra una reserva sin acompañante y luego se cancela la reserva. Se verifica que
     * el estado de la reserva cambie a CANCELADA.
     */
    @Test
    @DisplayName("Cancelar una reserva")
    public void testCancelarReserva() {
        // Crear pasajero
        Pasajero pasajero = new Pasajero("Juan", "Pérez", "12345678", "juan.perez@gmail.com", "Pass7w7ord@");

        // Registrar reserva sin acompañante
        agencia.registrarReservaSinAcompaniante("Buenos Aires", "Madrid", "2024-12-01", "2024-12-10", ClaseReserva.BUSINESS, pasajero);

        // Cancelar la reserva
        Reserva reserva = agencia.obtenerReservasPorClase(ClaseReserva.BUSINESS).get(0);
        assertEquals(EstadoReserva.RESERVADA, reserva.getEstado(), "El estado inicial debería ser RESERVADA");
        agencia.cancelarReserva(reserva);
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado(), "El estado debería ser CANCELADA");
    }

    
    /**
     * Prueba para obtener reservas por clase.
     * 
     * Se registran varias reservas y se verifica que la lista de reservas obtenidas por una clase específica contenga
     * solo las reservas correspondientes a esa clase.
     */
    @Test
    @DisplayName("Obtener reservas por clase")
    void obtenerReservasPorClaseTest() {
        // Crear pasajeros
        Pasajero pasajero1 = new Pasajero("Victor", "Lopez", "39665212", "victor@gmail.com", "Perro7s8ss@");
        Pasajero pasajero2 = new Pasajero("Jose", "Marti", "40785212", "martiii@gmail.com", "Gato4rr6!");

        // Registrar reservas
        agencia.registrarReservaSinAcompaniante("Buenos Aires", "San Pablo", "2024-09-20", "2024-09-30", ClaseReserva.ECONOMY, pasajero1);
        agencia.registrarReservaSinAcompaniante("Buenos Aires", "Cali", "2024-10-01", "2024-10-10", ClaseReserva.BUSINESS, pasajero2);

        // Obtener reservas por clase
        List<Reserva> reservasEconomy = agencia.obtenerReservasPorClase(ClaseReserva.ECONOMY);

        // Verificar que la lista contiene solo una reserva en clase ECONOMY
        assertEquals(1, reservasEconomy.size(), "La lista de reservas en clase ECONOMY debería contener una reserva");
        assertEquals(ClaseReserva.ECONOMY, reservasEconomy.get(0).getClase(), "La clase de la reserva debería ser ECONOMY");
    }
    
       
    
}