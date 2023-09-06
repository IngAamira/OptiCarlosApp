package com.opticarlos.infrastructure.entity;

import com.opticarlos.domain.Gender;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;

/**
 * Entidad que representa un producto en la base de datos.
 */
@Entity
@Table(name = "products")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    /**
     * ID único del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @jakarta.persistence.Id
    private Long productId;

    /**
     * Nombre del producto.
     */
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String name;

    /**
     * Precio del producto.
     */
    @NotNull(message = "El precio del producto no puede estar vacío")
    @DecimalMin(value = "0.0", message = "El precio debe ser igual o mayor a 0")
    private Double price;

    /**
     * Marca del producto.
     */
    private String brand;

    /**
     * Género al que está dirigido el producto.
     */
    @NotNull(message = "El género del producto no puede estar vacío")
    private Gender gender;

    /**
     * Indica si el producto está activo o no.
     * Valor predeterminado: true
     */
    private boolean active;

    /**
     * ID de la categoría a la que pertenece el producto.
     */
    // Relación ManyToOne con CategoryEntity
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

}
