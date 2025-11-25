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
public class Caso2Test {
    
    public Caso2Test() {
    }

    Caso2 manager = new Caso2();
    
    @Test
    void testAgregaaritemvalido() {
        manager.addItem("Teclado", 10);
        manager.addItem("Teclado", 5);

        assertEquals(15, manager.getStock("Teclado"), "El stock debería ser 15");
    }


    @Test
    void testCantidadGrande() {
        // Valida que se lance IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem("Mouse", 10001);
        });
        assertEquals("La cantidad no puede exceder 1000", exception.getMessage());
    }


    @Test
    void testProductoExiste() {
        manager.addItem("Monitor", 1);
        assertTrue(manager.containsProduct("Monitor"), "El inventario debería contener 'Monitor'");
    }

    @Test
    void testProductoNoexciste() {
        assertFalse(manager.containsProduct("GamerChair"), "El inventario no debería tener este ítem");
    }

    @Test
    void testNombreCorto() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem("A", 10);
        });
        assertEquals("El nombre debe tener entre 2 y 50 caracteres", exception.getMessage());
    }

    @Test
    void testVaariasAsserciones() {
        manager.addItem("Laptop", 20);

        assertAll("Propiedades del producto Laptop",
            () -> assertEquals(20, manager.getStock("Laptop")),
            () -> assertTrue(manager.containsProduct("Laptop")),
            () -> assertNotEquals(0, manager.getStock("Laptop"))
        );
    }
    
}
