package com.opticarlos.presentation.controller;

import com.opticarlos.application.services.ProductServices;
import com.opticarlos.domain.Product;
import com.opticarlos.domain.Category;
import com.opticarlos.infrastructure.entity.ProductEntity;
import com.opticarlos.infrastructure.dto.ProductRequest;
import com.opticarlos.infrastructure.dto.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para manejar las operaciones relacionadas con los productos.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    /**
     * Obtiene todos los productos disponibles o filtra por nombre.
     *
     * @param filterBy Filtro opcional por nombre del producto.
     * @return Una lista de productos o una lista vacía si no se encuentran productos.
     */
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

    /**
     * Obtiene un producto por su ID.
     *
     * @param productId El ID del producto a buscar.
     * @return El producto encontrado o un error 404 si no se encuentra.
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId) {
        Product product = productServices.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(ProductResponse.fromProduct(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo producto.
     *
     * @param productRequest La información del producto a crear.
     * @return El producto creado o un error 400 si los datos son inválidos.
     */
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductEntity productEntity = productRequest.toProductEntity();
        Product createdProduct = productServices.createProduct(productEntity);
        ProductResponse productResponse = ProductResponse.fromProduct(createdProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    /**
     * Actualiza un producto existente por su ID.
     *
     * @param productId      El ID del producto a actualizar.
     * @param productRequest La información actualizada del producto.
     * @return El producto actualizado o un error 404 si no se encuentra.
     */
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductRequest productRequest) {
        ProductEntity productEntity = productRequest.toProductEntity();
        Product updatedProduct = productServices.updateProduct(productId, productEntity);
        if (updatedProduct != null) {
            ProductResponse productResponse = ProductResponse.fromProduct(updatedProduct);
            return ResponseEntity.ok(productResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param productId El ID del producto a eliminar.
     * @return Una respuesta sin contenido (204) si el producto se eliminó con éxito,
     *         o un error 404 si no se encuentra.
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        boolean deleted = productServices.deleteProduct(productId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Obtiene una lista de productos por categoría.
     *
     * @param category La categoría de productos a buscar.
     * @return Una lista de productos en la categoría especificada o una lista vacía si no se encuentran.
     */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable Category category) {
        List<Product> products = productServices.getProductsByCategory(category);
        List<ProductResponse> productResponses = products.stream()
                .map(ProductResponse::fromProduct)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productResponses);
    }
}
