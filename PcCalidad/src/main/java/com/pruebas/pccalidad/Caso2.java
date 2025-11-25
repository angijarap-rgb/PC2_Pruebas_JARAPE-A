/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebas.pccalidad;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Angie
 */
public class Caso2 {
    private Map<String, Integer> inventory = new HashMap<>();

public void addItem(String item, int quantity) {
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        String cleanItem = item.trim();
        if (cleanItem.length() < 2 || cleanItem.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 50 caracteres");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (quantity > 1000) {
            throw new IllegalArgumentException("La cantidad no puede exceder 1000");
        }
        inventory.put(cleanItem, inventory.getOrDefault(cleanItem, 0) + quantity);
    }

    public int getStock(String item) {
        return inventory.getOrDefault(item, 0);
    }

    // Método nuevo para validar assertTrue/assertFalse
    public boolean containsProduct(String item) {
        return inventory.containsKey(item);
    }
}
