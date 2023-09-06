package com.opticarlos.application.exceptions;

public class InvalidProductDataException extends RuntimeException {

    public InvalidProductDataException(String message) {
        super("Invalid product data: " + message);
    }

}
