package com.opticarlos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Esta clase representa un producto en la aplicación.
 */
@Data
@AllArgsConstructor
@ToString
public class Product {

    private Integer id;
    private String code;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    /**
     * Constructor de la clase Product.
     * Genera un código UUID único para el producto.
     */
    public Product() {
        this.setCode(UUID.randomUUID().toString());
    }

}