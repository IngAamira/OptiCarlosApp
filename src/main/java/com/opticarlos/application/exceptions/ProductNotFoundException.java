package com.opticarlos.application.exceptions;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un producto en base a su ID.
 */
public class ProductNotFoundException extends RuntimeException {

    /**
     * Crea una nueva instancia de ProductNotFoundException con el ID del producto no encontrado.
     *
     * @param productId El ID del producto que no se pudo encontrar.
     */
    public ProductNotFoundException(Long productId) {
        super("Product not found with ID: " + productId);
    }

}
