package com.opticarlos.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Clase que representa la entidad Product en la base de datos.
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class ProductEntity {

    /**
     * Identificador único del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Código único del producto.
     */
    private String code;

    /**
     * Nombre del producto.
     */
    private String name;

    /**
     * Descripción del producto.
     */
    private String description;

    /**
     * Ruta de la imagen asociada al producto.
     */
    private String image;

    /**
     * Precio del producto.
     */
    private BigDecimal price;

    /**
     * Fecha en que se creó el producto.
     */
    private LocalDateTime dateCreated;

    /**
     * Fecha en que se actualizó el producto por última vez.
     */
    private LocalDateTime dateUpdated;

}
