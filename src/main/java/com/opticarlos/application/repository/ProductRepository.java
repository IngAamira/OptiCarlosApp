package com.opticarlos.application.repository;

import com.opticarlos.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {

    /**
     * Encuentra un producto por su ID.
     *
     * @param productId El ID del producto a buscar.
     * @return El producto encontrado o un Optional vacío si no se encuentra.
     */
    Optional<ProductEntity> findById(Long productId);

    /**
     * Guarda un nuevo producto o actualiza un producto existente.
     *
     * @param productEntity El producto a guardar o actualizar.
     * @return El producto guardado o actualizado.
     */
    ProductEntity save(ProductEntity productEntity);

    /**
     * Elimina un producto por su ID.
     *
     * @param productId El ID del producto a eliminar.
     */
    void deleteById(Long productId);

    /**
     * Obtiene todos los productos disponibles.
     *
     * @return Una lista de productos disponibles.
     */
    List<ProductEntity> findAll();

/*    *//**
     * Obtiene productos por su categoría.
     *
     //* @param categoryId El ID de la categoría de productos.
     * @return Una lista de productos pertenecientes a la categoría especificada.
     *//*
    List<ProductEntity> getProductsByCategoryId(Long categoryId);*/

    List<ProductEntity> findAllByNameContaining(String keyword);

}
