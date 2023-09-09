package com.opticarlos.infrastructure.entity;

import com.opticarlos.domain.Category;
import com.opticarlos.domain.Gender;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Esta clase representa la entidad de productos en la base de datos.
 */
@Entity
@Table(name = "products")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @jakarta.persistence.Id
    private Long productId;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(min = 1, max = 255, message = "La longitud del nombre debe estar entre 1 y 255 caracteres")
    private String name;

    @NotNull(message = "El precio del producto no puede estar vacío")
    @DecimalMin(value = "0.0", message = "El precio debe ser igual o mayor a 0")
    @Column(columnDefinition = "NUMERIC(10,2)") // Define la precisión como NUMERIC(10,2)
    private Double price;

    @Size(max = 255, message = "La longitud de la marca no puede exceder los 255 caracteres")
    private String brand;

    @NotNull(message = "El género del producto no puede estar vacío")
    @Enumerated(EnumType.STRING) // Especifica cómo se debe almacenar el Enum en la base de datos
    private Gender gender;

    @NotNull(message = "La categoría del producto no puede estar vacía")
    @Enumerated(EnumType.STRING) // Especifica cómo se debe almacenar el Enum en la base de datos
    private Category category;

    @NotNull(message = "El estado activo/inactivo del producto no puede estar vacío")
    private Boolean active;

    @Min(value = 0, message = "El stock debe ser igual o mayor a 0")
    private Integer stock;

    @Size(max = 1000, message = "La longitud de la descripción no puede exceder los 1000 caracteres")
    private String description;

    @Column(name = "date_created", updatable = false)
    @NotNull(message = "La fecha de creación no puede estar vacía")
    private LocalDateTime dateCreated;

    @Column(name = "date_updated")
    @NotNull(message = "La fecha de actualización no puede estar vacía")
    private LocalDateTime dateUpdated;

    @Size(max = 255, message = "La longitud del nombre de la imagen no puede exceder los 255 caracteres")
    private String image;

    /**
     * Método ejecutado antes de persistir la entidad en la base de datos para establecer la fecha de creación.
     */
    @PrePersist
    protected void onCreate() {
        dateCreated = LocalDateTime.now();
    }

    /**
     * Método ejecutado antes de actualizar la entidad en la base de datos para establecer la fecha de actualización.
     */
    @PreUpdate
    protected void onUpdate() {
        dateUpdated = LocalDateTime.now();
    }

}
