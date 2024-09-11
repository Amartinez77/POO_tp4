package ar.edu.unju.fi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.dominio.Pasajero;

class PasajeroTest {
	
	@Test
	@DisplayName("Registro de pasajero con contraseña válida ")
	
	public void registrarPasajeroTest() {
	
		Pasajero pasajero1 = new Pasajero("Victoria", "Martinez", "39665212", "vickMart@gmail.com", "Pa9sswo1rd.");
		Pasajero pasajero2 = new Pasajero("Manuel", "Belgrano", "8956123", "Mbelgrano@gmail.com", "Pass1s1m*");
		Pasajero pasajero3 = new Pasajero("Juan", "Vasquez", "24556555", "vasquez@gmail.com", "Mman9der1!");
		Pasajero pasajero4 = new Pasajero("Pablo", "Juarez", "11574666", "pab.juarez@gmail.com", "dddR4yy4@");
		Pasajero pasajero5 = new Pasajero("Mabel", "Flores", "33648512", "floresM@gmail.com", "1@pPomjKf7");
		
		assertTrue(pasajero1.validarPassword(), "La contraseña debe ser válida");
		assertTrue(pasajero2.validarPassword(), "La contraseña debe ser válida");
		assertTrue(pasajero3.validarPassword(), "La contraseña debe ser válida");
		assertTrue(pasajero4.validarPassword(), "La contraseña debe ser válida");
		assertTrue(pasajero5.validarPassword(), "La contraseña debe ser válida");
		
	}
	
	
	@Test
	@DisplayName("Registro de pasajero con contraseña inválida (menos de 2 numeros)")
	
	public void registrarPasajeroInvalidoTest() {
		
		Pasajero pasajero1= new Pasajero("Martin", "Bueno", "41587261", "martin@gmail.com", "gato12*");
		assertFalse(pasajero1.validarPassword(), "La contraseña debe ser inválida");
		
		
	}
	
	
	@Test
	@DisplayName("Registro de pasajero con contraseña inválida (sin carácter especial)")
	public void registrarPasajeroConPasswordInvalidaTest3() {
		
		Pasajero pasajero4 = new Pasajero("Pedro", "Lopez", "39665215", "pedroLopez@gmail.com", "Gato9512");
		
		
		assertFalse(pasajero4.validarPassword(), "La contraseña debería ser inválida (sin carácter especial)");
	}
	
	
	@Test
	@DisplayName("Registro de pasajero con contraseña inválida (números consecutivos)")
	public void registrarPasajeroConPasswordInvalidaTest2() {
		// Crear un pasajero con una contraseña inválida (números consecutivos)
		Pasajero pasajero3 = new Pasajero("Laura", "Garcia", "39665214", "lauraGarcia@gmail.com", "Gato99*1");
		
		// Comprobar si la contraseña es inválida
		assertFalse(pasajero3.validarPassword(), "La contraseña debería ser inválida (números consecutivos)");
	}

}
