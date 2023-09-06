package com.opticarlos.application.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Integer productId) {
        super("Product not found with ID: " + productId);
    }

}
