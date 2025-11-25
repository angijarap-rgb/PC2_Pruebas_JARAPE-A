/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.pruebas.pccalidad;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Angie
 */

public class Caso3Test {

    @Test
    public void testEmailNulo() {
        Caso3 c = new Caso3();
        assertThrows(IllegalArgumentException.class, () -> c.isValidEmail(null));
    }

    @Test
    public void testEmailVacio() {
        Caso3 c = new Caso3();
        assertThrows(IllegalArgumentException.class, () -> c.isValidEmail("   "));
    }

    @Test
    public void testEmailMuyCorto() {
        Caso3 c = new Caso3();
        assertFalse(c.isValidEmail("a@b.c")); // 5 caracteres → cubre esa línea roja
    }

    @Test
    public void testEmailMuyLargo() {
        Caso3 c = new Caso3();
        String local = "a".repeat(250);
        String email = local + "@a.com"; // >254 chars
        assertFalse(c.isValidEmail(email));
    }

    @Test
    public void testEmailConEspacio() {
        Caso3 c = new Caso3();
        assertFalse(c.isValidEmail("us er@gmail.com"));
    }

    @Test
    public void testEmailSinArroba() {
        Caso3 c = new Caso3();
        assertFalse(c.isValidEmail("usuario.gmail.com"));
    }

    @Test
    public void testEmailConDosArrobas() {
        Caso3 c = new Caso3();
        assertFalse(c.isValidEmail("usuario@@gmail.com"));
    }

    @Test
    public void testLocalPartInvalido() {
        Caso3 c = new Caso3();
        assertFalse(c.isValidEmail(".usuario@gmail.com"));
        assertFalse(c.isValidEmail("usuario.@gmail.com"));
        assertFalse(c.isValidEmail("us..er@gmail.com"));
        assertFalse(c.isValidEmail("us$er@gmail.com"));
    }

    @Test
    public void testDominioInvalido() {
        Caso3 c = new Caso3();
        assertFalse(c.isValidEmail("usuario@a.c"));
        assertFalse(c.isValidEmail("usuario@gmail"));
    }

    @Test
    public void testEmailValido() {
        Caso3 c = new Caso3();
        assertTrue(c.isValidEmail("cliente123@tienda.com"));
    }
}
