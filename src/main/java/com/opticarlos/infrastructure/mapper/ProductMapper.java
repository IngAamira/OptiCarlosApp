package com.opticarlos.infrastructure.mapper;

import com.opticarlos.domain.Product;
import com.opticarlos.infrastructure.entity.ProductEntity;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "category.categoryId", target = "categoryId") // Mapea categoryId desde la propiedad "category"
    })
    Product toProduct(ProductEntity productEntity);

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "categoryId", target = "category.categoryId") // Mapea categoryId hacia la propiedad "category"
    })
    ProductEntity toProductEntity(Product product);

    List<Product> toProducts(List<ProductEntity> productEntities);

}

