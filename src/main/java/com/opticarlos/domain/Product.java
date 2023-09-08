package com.opticarlos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Representa un producto en el dominio del negocio.
 */
@Data
@AllArgsConstructor
@Builder
public class Product {

    private Long productId;

    /**
     * El nombre del producto.
     */
    private String name;

    /**
     * El precio del producto.
     */
    private Double price;

    /**
     * La marca del producto.
     */
    private String brand;

    /**
     * El género al que está dirigido el producto.
     */
    private Gender gender;

    /**
     * La categoría a la que pertenece el producto.
     */
    private Category category;

    /**
     * Indica si el producto está activo o no.
     */
    private boolean active;

    /**
     * La cantidad disponible en stock.
     */
    private int stock;

    /**
     * La descripción del producto.
     */
    private String description;

    /**
     * La fecha y hora en que se creó el producto.
     */
    private LocalDateTime dateCreated;

    /**
     * La fecha y hora en que se actualizó por última vez el producto.
     */
    private LocalDateTime dateUpdated;

    /**
     * El nombre del archivo de imagen asociado al producto.
     */
    private String image;

}
