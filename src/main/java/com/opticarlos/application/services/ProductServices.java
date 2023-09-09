package com.opticarlos.application.services;

import com.opticarlos.application.exceptions.InvalidProductDataException;
import com.opticarlos.application.exceptions.ProductNotFoundException;
import com.opticarlos.domain.Product;
import com.opticarlos.domain.Category;
import com.opticarlos.infrastructure.adapter.ProductJpaRepository;
import com.opticarlos.infrastructure.entity.ProductEntity;
import com.opticarlos.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para administrar productos.
 */
@Service
public class ProductServices {

    private final ProductJpaRepository productJpaRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductServices(ProductJpaRepository productJpaRepository, ProductMapper productMapper) {
        this.productJpaRepository = productJpaRepository;
        this.productMapper = productMapper;
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param productId El ID del producto a buscar.
     * @return El producto encontrado.
     * @throws ProductNotFoundException Si el producto no se encuentra.
     */
    public Product getProductById(Long productId) {
        Optional<ProductEntity> productEntityOptional = productJpaRepository.findById(productId);
        if (productEntityOptional.isEmpty()) {
            throw new ProductNotFoundException(productId);
        }
        return productMapper.toProduct(productEntityOptional.get());
    }

    /**
     * Obtiene todos los productos que coincidan con un filtro.
     *
     * @param filterBy El filtro para buscar productos por nombre.
     * @return Una lista de productos que coinciden con el filtro.
     */
    public List<Product> getAllProducts(String filterBy) {
        List<ProductEntity> productEntities = productJpaRepository.findAllByNameContaining(filterBy);
        return productMapper.toProducts(productEntities);
    }

    /**
     * Crea un nuevo producto.
     *
     * @param productEntity El producto a crear.
     * @return El producto creado.
     * @throws InvalidProductDataException Si los datos del producto son inválidos.
     */
    public Product createProduct(ProductEntity productEntity) {
        if (productEntity.getName() == null || productEntity.getName().isEmpty()) {
            throw new InvalidProductDataException("Product name cannot be empty");
        }
        ProductEntity savedEntity = productJpaRepository.save(productEntity);
        return productMapper.toProduct(savedEntity);
    }

    /**
     * Actualiza un producto existente por su ID.
     *
     * @param productId     El ID del producto a actualizar.
     * @param productEntity Los nuevos datos del producto.
     * @return El producto actualizado.
     * @throws ProductNotFoundException Si el producto no se encuentra.
     */
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

    /**
     * Elimina un producto por su ID.
     *
     * @param productId El ID del producto a eliminar.
     * @return true si el producto se eliminó con éxito, de lo contrario false.
     * @throws ProductNotFoundException Si el producto no se encuentra.
     */
    public boolean deleteProduct(Long productId) {
        Optional<ProductEntity> productEntityOptional = productJpaRepository.findById(productId);
        if (productEntityOptional.isEmpty()) {
            throw new ProductNotFoundException(productId);
        }
        productJpaRepository.deleteById(productId);
        return true;
    }

    /**
     * Obtiene productos por su categoría.
     *
     * @param category La categoría de los productos a buscar.
     * @return Una lista de productos pertenecientes a la categoría especificada.
     */
    public List<Product> getProductsByCategory(Category category) {
        List<ProductEntity> productEntities = productJpaRepository.findByCategory(category);
        List<Product> products = new ArrayList<>();

        for (ProductEntity productEntity : productEntities) {
            Product product = new Product(
                    productEntity.getProductId(),
                    productEntity.getName(),
                    productEntity.getPrice(),
                    productEntity.getBrand(),
                    productEntity.getGender(),
                    category,
                    productEntity.getActive(),
                    productEntity.getStock(),
                    productEntity.getDescription(),
                    productEntity.getDateCreated(),
                    productEntity.getDateUpdated(),
                    productEntity.getImage()
            );
            products.add(product);
        }

        return products;
    }

}
