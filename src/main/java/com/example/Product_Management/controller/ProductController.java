package com.example.Product_Management.controller;

import com.example.Product_Management.model.Product;
import com.example.Product_Management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return service.createNewProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/id")
    public Product getProductById(@PathVariable UUID id){
        return service.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable UUID id){
        service.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(
            @PathVariable UUID id,
            @RequestBody Product product
    ) {
        Product updated = service.updateProductById(id, product);
        return ResponseEntity.ok(updated);
    }
}
