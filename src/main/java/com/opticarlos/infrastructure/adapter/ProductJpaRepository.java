package com.opticarlos.infrastructure.adapter;

import com.opticarlos.domain.Category;
import com.opticarlos.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByNameContaining(String name);

    List<ProductEntity> findByCategory(Category category); // Método para obtener productos por categoría

}
