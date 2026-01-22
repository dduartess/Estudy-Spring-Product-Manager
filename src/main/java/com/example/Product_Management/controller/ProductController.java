package com.example.Product_Management.controller;

import com.example.Product_Management.dto.ProductRequestDTO;
import com.example.Product_Management.dto.ProductResponseDTO;
import com.example.Product_Management.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductResponseDTO save(@RequestBody ProductRequestDTO dto) {
        return service.createNewProduct(dto);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable UUID id){
        return service.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable UUID id){
        service.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProductById(
            @PathVariable UUID id,
            @RequestBody ProductRequestDTO dto
    ) {
        ProductResponseDTO updated = service.updateProductById(id, dto);
        return ResponseEntity.ok(updated);
    }
}
