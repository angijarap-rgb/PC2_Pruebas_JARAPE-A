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
public class Caso1Test {
    
    public Caso1Test() {
    }
    
    Caso1 caso1 = new Caso1();

    @Test
    public void PruebaValidPassword() {
        assertTrue(caso1.isValid("Secure123!"));
    }

    @Test
    public void PruebaNullPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            caso1.isValid(null);
        });
        assertEquals("La contraseña no puede ser nula o vacía", exception.getMessage());
    }

    @Test
    public void PruebaInvalidPassword() {
        assertFalse(caso1.isValid("nosecura"));
    }




    @Test
    void testPasswordComplejaValida() {
        String password = "Valid@123";

        assertAll("Validaciones para una contraseña válida",
                () -> assertTrue(password.length() >= 8),
                () -> assertTrue(password.length() <= 64),
                () -> assertTrue(password.matches(".*[A-Z].*")),
                () -> assertTrue(password.matches(".*[a-z].*")),
                () -> assertTrue(password.matches(".*\\d.*")),
                () -> assertTrue(password.matches(".*[@#$%^&+=!].*")),
                () -> assertFalse(password.matches(" "))
        );
    }

    @Test
    void testContraseñaCorta(){
        assertFalse(caso1.isValid("H0l@"));
    }
    @Test
    void testPasswordMuylarga(){
        assertFalse(caso1.isValid("1234567891011124310320761076176751765657165176517771765717016701765107651706571765"));
    }
  
}
