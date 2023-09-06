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
