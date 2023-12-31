package com.opticarlos.infrastructure.adapter;

import com.opticarlos.domain.Category;
import com.opticarlos.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio JPA para acceder a los datos de productos en la base de datos.
 */
@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    /**
     * Busca y devuelve una lista de productos cuyos nombres contienen la cadena especificada.
     *
     * @param name La cadena a buscar en los nombres de los productos.
     * @return Una lista de productos que coinciden con el criterio de búsqueda.
     */
    List<ProductEntity> findAllByNameContaining(String name);

    /**
     * Busca y devuelve una lista de productos que pertenecen a una categoría específica.
     *
     * @param category La categoría de productos para la cual se realizará la búsqueda.
     * @return Una lista de productos que pertenecen a la categoría especificada.
     */
    List<ProductEntity> findByCategory(Category category);

}
