package com.opticarlos.application.repository;

import com.opticarlos.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para gestionar productos en la base de datos.
 */
@Repository
public interface ProductRepository {

    /**
     * Busca un producto por su ID.
     *
     * @param productId El ID del producto a buscar.
     * @return Un Optional que contiene el producto encontrado, o un Optional vacío si no se encuentra.
     */
    Optional<ProductEntity> findById(Long productId);

    /**
     * Guarda un producto en la base de datos.
     *
     * @param productEntity El producto a guardar.
     * @return El producto guardado.
     */
    ProductEntity save(ProductEntity productEntity);

    /**
     * Elimina un producto por su ID.
     *
     * @param productId El ID del producto a eliminar.
     */
    void deleteById(Long productId);

    /**
     * Obtiene todos los productos en la base de datos.
     *
     * @return Una lista de todos los productos.
     */
    List<ProductEntity> findAll();

    /**
     * Busca productos cuyos nombres contengan la palabra clave especificada.
     *
     * @param keyword La palabra clave para buscar en los nombres de los productos.
     * @return Una lista de productos que coinciden con la palabra clave.
     */
    List<ProductEntity> findAllByNameContaining(String keyword);

    /**
     * Busca productos por categoría.
     *
     * @param category La categoría de productos a buscar.
     * @return Una lista de productos que pertenecen a la categoría especificada.
     */
    List<ProductEntity> findByCategory(String category);

}
