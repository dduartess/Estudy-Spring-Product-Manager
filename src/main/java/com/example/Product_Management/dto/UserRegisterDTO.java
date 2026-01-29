package com.example.Product_Management.dto;

import com.example.Product_Management.model.enums.UserRole;

public record UserRegisterDTO(String login, String password, UserRole role) {

}
