package com.example.Product_Management.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String nameProduct,
        String descriptionProduct,
        BigDecimal priceProduct
) {}
