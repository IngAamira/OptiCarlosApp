package com.opticarlos.application.exceptions;

/**
 * Excepción personalizada para representar datos de producto no válidos.
 * Se lanza cuando se intenta crear o actualizar un producto con datos no válidos.
 */
public class InvalidProductDataException extends RuntimeException {

    /**
     * Crea una nueva instancia de InvalidProductDataException con un mensaje de error personalizado.
     *
     * @param message El mensaje de error que describe la razón de la excepción.
     */
    public InvalidProductDataException(String message) {
        super("Invalid product data: " + message);
    }

}
