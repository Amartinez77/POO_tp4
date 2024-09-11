package ar.edu.unju.fi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.dominio.Pasajero;
import ar.edu.unju.fi.dominio.Reserva;
import ar.edu.unju.fi.util.ClaseReserva;
import ar.edu.unju.fi.util.EstadoReserva;

class ReservaTest {
	
	
	private Reserva reserva;
	private Pasajero pasajero;
	
	@BeforeEach
	public void setUp() {
		
		pasajero = new Pasajero("Juan", "Pérez", "12345678", "juan.perez@gmail.com", "Password123!");
        reserva = new Reserva("Buenos Aires", "Madrid", "01-12-2024", "10-12-2024", ClaseReserva.BUSINESS, pasajero);
				
	}
	

	@Test
	@DisplayName("Registro de Reserva sin acompañante")
	public void testRegistrarReservaSinAcompanante() {
		
		assertNull(reserva.getAcompañante(), "La reserva no deberia tener acompañante");
		assertEquals(ClaseReserva.BUSINESS, reserva.getClase(), "La clase deberia ser Business");
		assertEquals(EstadoReserva.RESERVADA, reserva.getEstado(), "El estado deberia ser RESERVADA");
		
	}
	
	
	@Test
	@DisplayName("Registro de reserva con acompañante")
	
	public void registrarReservaConAcompañanteTest() {
		
		Pasajero acompaniante = new Pasajero("Pedro", "Picapierdra", "17985621", "pedroPicapiedra@gmail.com", null);
		reserva.setAcompaniante(acompaniante);
		assertNotNull(reserva.getAcompañante(), "La reseva deberia tener un acompañante");
		assertEquals("Pedro", reserva.getAcompañante().getNombreString(), "el nombre del acompañante deberia ser Pedro");
		
	}
	
	@Test
    public void testCancelarReserva() {
		assertEquals(EstadoReserva.RESERVADA, reserva.getEstado(), "El estado inicial debería ser RESERVADA");
        reserva.cancelarReserva();
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado(), "El estado debería ser CANCELADA");
    }
	

}
