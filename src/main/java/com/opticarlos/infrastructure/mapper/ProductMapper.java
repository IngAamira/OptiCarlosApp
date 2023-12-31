package com.opticarlos.infrastructure.mapper;

import com.opticarlos.domain.Product;
import com.opticarlos.infrastructure.entity.ProductEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta interfaz define la operación de mapeo entre objetos Product y ProductEntity.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    /**
     * Convierte una entidad de producto (ProductEntity) en un objeto de dominio de producto (Product).
     *
     * @param productEntity La entidad de producto a convertir.
     * @return Un objeto de dominio de producto convertido.
     */
    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "category", target = "category"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated")
    })
    Product toProduct(ProductEntity productEntity);

    /**
     * Convierte un objeto de dominio de producto (Product) en una entidad de producto (ProductEntity).
     *
     * @param product El objeto de dominio de producto a convertir.
     * @return Una entidad de producto convertida.
     */
    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "category", target = "category"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated")
    })
    ProductEntity toProductEntity(Product product);

    /**
     * Convierte una lista de entidades de producto (ProductEntity) en una lista de objetos de dominio de producto (Product).
     *
     * @param productEntities La lista de entidades de producto a convertir.
     * @return Una lista de objetos de dominio de producto convertida.
     */
    default List<Product> toProducts(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

}
