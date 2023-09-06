package com.opticarlos.application.services;

import com.opticarlos.application.exceptions.InvalidProductDataException;
import com.opticarlos.application.exceptions.ProductNotFoundException;
import com.opticarlos.domain.Product;
import com.opticarlos.infrastructure.adapter.ProductJpaRepository;
import com.opticarlos.infrastructure.entity.ProductEntity;
import com.opticarlos.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    private final ProductJpaRepository productJpaRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductServices(ProductJpaRepository productJpaRepository, ProductMapper productMapper) {
        this.productJpaRepository = productJpaRepository;
        this.productMapper = productMapper;
    }

    public Product getProductById(Long productId) {
        Optional<ProductEntity> productEntityOptional = productJpaRepository.findById(productId);
        if (productEntityOptional.isEmpty()) {
            throw new ProductNotFoundException(productId);
        }
        return productMapper.toProduct(productEntityOptional.get());
    }

    public List<Product> getAllProducts(String filterBy) {
        List<ProductEntity> productEntities = productJpaRepository.findAllByNameContaining(filterBy);
        return productMapper.toProducts(productEntities);
    }

    public Product createProduct(ProductEntity productEntity) {
        if (productEntity.getName() == null || productEntity.getName().isEmpty()) {
            throw new InvalidProductDataException("Product name cannot be empty");
        }
        ProductEntity savedEntity = productJpaRepository.save(productEntity);
        return productMapper.toProduct(savedEntity);
    }

    public Product updateProduct(Long productId, ProductEntity productEntity) {
        Optional<ProductEntity> productEntityOptional = productJpaRepository.findById(productId);
        if (productEntityOptional.isEmpty()) {
            throw new ProductNotFoundException(productId);
        }

        ProductEntity existingProduct = productEntityOptional.get();
        existingProduct.setName(productEntity.getName());
        existingProduct.setPrice(productEntity.getPrice());

        ProductEntity updatedEntity = productJpaRepository.save(existingProduct);
        return productMapper.toProduct(updatedEntity);
    }

    public boolean deleteProduct(Long productId) {
        Optional<ProductEntity> productEntityOptional = productJpaRepository.findById(productId);
        if (productEntityOptional.isEmpty()) {
            throw new ProductNotFoundException(productId);
        }
        productJpaRepository.deleteById(productId);
        return false;
    }
}
