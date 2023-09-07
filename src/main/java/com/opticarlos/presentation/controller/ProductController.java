package com.opticarlos.presentation.controller;

import com.opticarlos.application.services.ProductServices;
import com.opticarlos.domain.Product;
import com.opticarlos.domain.Category;
import com.opticarlos.infrastructure.entity.ProductEntity;
import com.opticarlos.presentation.dto.ProductRequest;
import com.opticarlos.presentation.dto.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAllProducts(
            @RequestParam(defaultValue = "") String filterBy
    ) {
        List<Product> products = productServices.getAllProducts(filterBy);
        List<ProductResponse> productResponses = products.stream()
                .map(ProductResponse::fromProduct)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productResponses);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId) {
        Product product = productServices.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(ProductResponse.fromProduct(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductEntity productEntity = productRequest.toProductEntity(); // Utiliza el método toProductEntity() en lugar de toProduct()
        Product createdProduct = productServices.createProduct(productEntity);
        ProductResponse productResponse = ProductResponse.fromProduct(createdProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductRequest productRequest) {
        ProductEntity productEntity = productRequest.toProductEntity(); // Utiliza el método toProductEntity() en lugar de toProduct()
        Product updatedProduct = productServices.updateProduct(productId, productEntity);
        if (updatedProduct != null) {
            ProductResponse productResponse = ProductResponse.fromProduct(updatedProduct);
            return ResponseEntity.ok(productResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        boolean deleted = productServices.deleteProduct(productId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable Category category) {
        List<Product> products = productServices.getProductsByCategory(category);
        List<ProductResponse> productResponses = products.stream()
                .map(ProductResponse::fromProduct)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productResponses);
    }

}
