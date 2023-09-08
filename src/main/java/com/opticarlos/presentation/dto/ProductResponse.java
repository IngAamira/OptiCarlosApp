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
            @Mapping(source = "category", target = "category"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated")
    })
    Product toProduct(ProductEntity produ