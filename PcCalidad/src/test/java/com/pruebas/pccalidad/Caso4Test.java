/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.pruebas.pccalidad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Angie
 */

public class Caso4Test {

    @Test
    public void testTextoValido() {
        Caso4 caso = new Caso4();
        String resultado = caso.procesarTexto("Hola");
        Assertions.assertEquals("ALOH", resultado);
    }

    @Test
    public void testNormalizacion() {
        Caso4 caso = new Caso4();
        String resultado = caso.procesarTexto("   Mundo   ");
        Assertions.assertEquals("ODNUM", resultado);
    }

    // Texto nulo
    @Test
    public void testTextoNulo() {
        Caso4 caso = new Caso4();
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> caso.procesarTexto(null));

        Assertions.assertEquals("El texto no puede ser nulo", ex.getMessage());
    }

    // Texto vacío
    @Test
    public void testTextoVacio() {
        Caso4 caso = new Caso4();
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> caso.procesarTexto("   "));

        Assertions.assertEquals("El texto no puede estar vacío", ex.getMessage());
    }

    // Límite exacto: 1000 caracteres
    @Test
    public void testLimiteExacto() {
        Caso4 caso = new Caso4();
        String texto = "a".repeat(1000);
        String resultado = caso.procesarTexto(texto);
        Assertions.assertEquals(new StringBuilder(texto).reverse().toString().toUpperCase(), resultado);
    }

    // Límite excedido 1001 caracteres
    @Test
    public void testLimiteExcedido() {
        Caso4 caso = new Caso4();
        String texto = "a".repeat(1001);

        Exception ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> caso.procesarTexto(texto));

        Assertions.assertEquals("El texto excede el límite de 1000 caracteres", ex.getMessage());
    }
}
