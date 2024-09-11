package ar.edu.unju.fi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.dominio.Pasajero;

/**
 * Clase de prueba para la clase {@link Pasajero}.
 * 
 * Contiene tests para verificar la validez de las contraseñas de los pasajeros en diferentes escenarios.
 */
class PasajeroTest {

    /**
     * Prueba para verificar que las contraseñas válidas sean aceptadas.
     * 
     * Se crean varios pasajeros con contraseñas válidas y se verifica que el método
     * {@link Pasajero#validarPassword()} devuelva {@code true}.
     */
    @Test
    @DisplayName("Registro de pasajero con contraseña válida")
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
    
    

    /**
     * Prueba para verificar que las contraseñas inválidas (menos de 2 números) sean rechazadas.
     * 
     * Se crea un pasajero con una contraseña que no cumple con el criterio de tener al menos 2 números y
     * se verifica que el método {@link Pasajero#validarPassword()} devuelva {@code false}.
     */
    @Test
    @DisplayName("Registro de pasajero con contraseña inválida (menos de 2 números)")
    public void registrarPasajeroInvalidoTest() {
        Pasajero pasajero1 = new Pasajero("Martin", "Bueno", "41587261", "martin@gmail.com", "gato12*");
        assertFalse(pasajero1.validarPassword(), "La contraseña debe ser inválida");
    }
    

    /**
     * Prueba para verificar que las contraseñas inválidas (sin caracter especial) sean rechazadas.
     * 
     * Se crea un pasajero con una contraseña que no cumple con el criterio de tener al menos un caracter especial
     * y se verifica que el método {@link Pasajero#validarPassword()} devuelva {@code false}.
     */
    @Test
    @DisplayName("Registro de pasajero con contraseña inválida (sin carácter especial)")
    public void registrarPasajeroConPasswordInvalidaTest3() {
        Pasajero pasajero4 = new Pasajero("Pedro", "Lopez", "39665215", "pedroLopez@gmail.com", "Gato9512");
        assertFalse(pasajero4.validarPassword(), "La contraseña debería ser inválida (sin carácter especial)");
    }

    
    /**
     * Prueba para verificar que las contraseñas inválidas (números consecutivos) sean rechazadas.
     * 
     * Se crea un pasajero con una contraseña que no cumple con el criterio de no tener números consecutivos
     * y se verifica que el método {@link Pasajero#validarPassword()} devuelva {@code false}.
     */
    @Test
    @DisplayName("Registro de pasajero con contraseña inválida (números consecutivos)")
    public void registrarPasajeroConPasswordInvalidaTest2() {
        Pasajero pasajero3 = new Pasajero("Laura", "Garcia", "39665214", "lauraGarcia@gmail.com", "Gato99*1");
        assertFalse(pasajero3.validarPassword(), "La contraseña debería ser inválida (números consecutivos)");
    }
}
