package com.opticarlos.infrastructure.entity;

import com.opticarlos.domain.Category;
import com.opticarlos.domain.Gender;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;


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
    private String name;


    @NotNull(message = "El precio del producto no puede estar vacío")
    @DecimalMin(value = "0.0", message = "El precio debe ser igual o mayor a 0")
    private Double price;


    private String brand;


    @NotNull(message = "El género del producto no puede estar vacío")
    private Gender gender;

    private boolean active;

    private Category category;

}
