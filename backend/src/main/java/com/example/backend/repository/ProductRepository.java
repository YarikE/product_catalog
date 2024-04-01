package com.example.backend.repository;

import java.util.List;

import com.example.backend.domain.entity.Category;
import com.example.backend.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
