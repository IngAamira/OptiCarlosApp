package com.opticarlos.infrastructure.dto;

import com.opticarlos.domain.Category;
import com.opticarlos.domain.Gender;
import com.opticarlos.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long productId;
    private String name;
    private Double price;
    private String brand;
    private Gender gender;
    private boolean active;
    private Category category;

    /**
     * Crea un objeto ProductResponse a partir de un objeto Product.
     *
     * @param product El objeto Product del que se creará ProductResponse.
     * @return Un nuevo objeto ProductResponse con los datos del objeto Product proporcionado.
     */
    public static ProductResponse fromProduct(Product product) {
        return new ProductResponse(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getBrand(),
                product.getGender(),
                product.isActive(),
                product.getCategory()
        );
    }

}
