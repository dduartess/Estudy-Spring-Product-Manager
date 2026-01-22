package com.example.Product_Management.dto;

public record ProductRequestDTO(
        String nameProduct,
        String descriptionProduct,
        Double priceProduct
) {}
