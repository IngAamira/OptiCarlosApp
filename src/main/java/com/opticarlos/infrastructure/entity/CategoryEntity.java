package com.opticarlos.infrastructure.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Entidad que representa una categoría de productos en la base de datos.
 */
@Entity
@Table(name = "categories")
@Data
public class CategoryEntity {

    /**
     * ID único de la categoría.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    @jakarta.persistence.Id
    private Long categoryId;

    /**
     * Descripción de la categoría.
     */
    @NotBlank(message = "la descripción de la categoría no puede estar vacío")
    private String description;

    /**
     * Indica si la categoría está activa o no.
     */
    private boolean active;

    /**
     * Lista de productos.
     */
    // Relación OneToMany con ProductEntity
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products = new ArrayList<>();

}
