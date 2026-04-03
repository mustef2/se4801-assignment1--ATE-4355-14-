//ATE/4355/14
package com.shopwave.controller;

import com.shopwave.model.Product;
import com.shopwave.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ✅ GET all
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ✅ GET by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // ✅ CREATE
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }
}