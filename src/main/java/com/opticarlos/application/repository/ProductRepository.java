package com.opticarlos.application.repository;

import com.opticarlos.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {


    Optional<ProductEntity> findById(Long productId);

    ProductEntity save(ProductEntity productEntity);

    void deleteById(Long productId);

    List<ProductEntity> findAll();

    List<ProductEntity> findAllByNameContaining(String keyword);


}
