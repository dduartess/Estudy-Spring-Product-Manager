package com.example.Product_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Product_Management.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);

    String login(String login);
}
