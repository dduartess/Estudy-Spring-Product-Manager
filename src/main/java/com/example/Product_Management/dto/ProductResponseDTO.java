package com.example.Product_Management.dto;

import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
        String name,
        String description,
        Double priceProduct
) {}