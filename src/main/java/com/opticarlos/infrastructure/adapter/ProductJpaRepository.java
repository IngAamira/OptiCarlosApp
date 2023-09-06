package com.opticarlos.infrastructure.adapter;

import com.opticarlos.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {

/*    *//**
     * Obtiene productos por su categoría.
     *
     //* @param categoryId El ID de la categoría de productos.
     * @return Una lista de productos pertenecientes a la categoría especificada.
     *//*
    List<ProductEntity> findByCategoryId(Integer categoryId);*/

    List<ProductEntity> findAllByNameContaining(String name);

}
