package com.example.backend.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.backend.domain.entity.Product;
import com.example.backend.domain.entity.Category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByDescription(String description);

    List<Product> findByPrice(double price);

    List<Product> findByCategory(Category category);

    @Query("SELECT p FROM Product p WHERE p.add_date = :addDate")
    List<Product> findByAdd_date(LocalDate addDate);

    List<Product> findByStatus(Boolean status);
}