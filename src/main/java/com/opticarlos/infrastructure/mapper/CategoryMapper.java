package com.opticarlos.infrastructure.mapper;

import com.opticarlos.domain.Category;
import com.opticarlos.infrastructure.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Mapper que realiza la conversión entre objetos de tipo Category y CategoryEntity.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "products", target = "products") // Mapea la lista de productos
    })
/*    Category toCategory(CategoryEntity categoryEntity);
    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "products", target = "products") // Mapea la lista de productos también
    })*/
    CategoryEntity toCategoryEntity(CategoryEntity categoryEntity);

}

