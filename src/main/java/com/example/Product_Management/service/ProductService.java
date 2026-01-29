package com.example.Product_Management.service;

import com.example.Product_Management.dto.ProductRequestDTO;
import com.example.Product_Management.dto.ProductResponseDTO;
import com.example.Product_Management.exception.ResourceNotFoundException;
import com.example.Product_Management.model.products.Product;
import com.example.Product_Management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    private ProductResponseDTO toDTO(Product p) {
        return new ProductResponseDTO(
                p.getId(),
                p.getNameProduct(),
                p.getDescriptionProduct(),
                p.getPriceProduct()
        );
    }

    public List<ProductResponseDTO> getAllProducts() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public ProductResponseDTO getProductById(UUID id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
        return toDTO(product);
    }

    public ProductResponseDTO createNewProduct(ProductRequestDTO dto) {
        Product product = new Product();
        product.setNameProduct(dto.nameProduct());
        product.setDescriptionProduct(dto.descriptionProduct());
        product.setPriceProduct(dto.priceProduct());
        return toDTO(repository.save(product));
    }

    public void deleteProductById(UUID id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
        repository.delete(product);
    }

    public ProductResponseDTO updateProductById(UUID id, ProductRequestDTO dto) {
        Product oldProduct = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));

        oldProduct.setNameProduct(dto.nameProduct());
        oldProduct.setDescriptionProduct(dto.descriptionProduct());
        oldProduct.setPriceProduct(dto.priceProduct());

        return toDTO(repository.save(oldProduct));
    }
}