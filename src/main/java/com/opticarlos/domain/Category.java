package com.opticarlos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Clase que representa una categoría de productos en la óptica.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    /**
     * ID único de la categoría.
     */
    private Long categoryId;

    /**
     * Descripción de la categoría.
     */
    private String description;

    /**
     * Indica si la categoría está activa o no.
     */
    private boolean active;

    /**
     * Flujo reactivo de productos asociados a esta categoría.
     */
    private List<Product> products;

}