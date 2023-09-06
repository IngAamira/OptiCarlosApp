package com.opticarlos.infrastructure.mapper;

import com.opticarlos.domain.Product;
import com.opticarlos.infrastructure.entity.ProductEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    Product toProduct(ProductEntity productEntity);

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    ProductEntity toProductEntity(Product product);

    default List<Product> toProducts(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

}

