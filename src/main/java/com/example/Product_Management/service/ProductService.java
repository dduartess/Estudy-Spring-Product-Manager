package com.example.Product_Management.service;

import com.example.Product_Management.exception.ResourceNotFoundException;
import com.example.Product_Management.model.Product;
import com.example.Product_Management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository Repository) {
        this.repository = Repository;
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProductById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Produto não encontrado com id: " + id
                ));
    }

    public Product createNewProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProductById(UUID id) {
        repository.deleteById(id);
    }

    public Product updateProductById(UUID id, Product product) {
        Product oldProduct = getProductById(id);
        oldProduct.setNameProduct(product.getNameProduct());
        oldProduct.setDescriptionProduct(product.getDescriptionProduct());
        oldProduct.setPriceProduct(product.getPriceProduct());
        return repository.save(oldProduct);
    }
}
