package com.opticarlos.presentation.dto;

import com.opticarlos.domain.Category;
import com.opticarlos.domain.Gender;
import com.opticarlos.domain.Product;
import com.opticarlos.infrastructure.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String name;
    private Double price;
    private String brand;
    private Gender gender;
    private boolean active;
    private Category category;

    /**
     * Convierte este objeto ProductRequest en un objeto Product.
     *
     * @return Un objeto Product con los datos de este ProductRequest.
     */
    public Product toProduct() {
        return Product.builder()
                .name(name)
                .price(price)
                .brand(brand)
                .gender(gender)
                .active(active)
                .category(category)
                .build();
    }

    /**
     * Convierte este objeto ProductRequest en un objeto ProductEntity.
     *
     * @return Un objeto ProductEntity con los datos de este ProductRequest.
     */
    public ProductEntity toProductEntity() {
        return ProductEntity.builder()
                .name(name)
                .price(price)
                .brand(brand)
                .gender(gender)
                .active(active)
                .category(category)
                .build();
    }

}
