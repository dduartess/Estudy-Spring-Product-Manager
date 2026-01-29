package com.example.Product_Management.dto;

import com.example.Product_Management.model.enums.UserRole;

public record UserRegisterDTO(String username, String password, UserRole role) {

}
