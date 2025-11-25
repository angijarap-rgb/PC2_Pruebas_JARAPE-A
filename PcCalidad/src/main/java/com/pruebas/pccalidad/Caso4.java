/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebas.pccalidad;

/**
 *
 * @author Angie
 */

public class Caso4 {

    public String procesarTexto(String texto) {

        if (texto == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        if (texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }

        if (texto.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // Eliminar espacios al inicio y final
        String procesado = texto.trim();

        // Invertir el texto
        procesado = new StringBuilder(procesado).reverse().toString();

        // Convertir a mayúsculas
        procesado = procesado.toUpperCase();

        return procesado;
    }
}
