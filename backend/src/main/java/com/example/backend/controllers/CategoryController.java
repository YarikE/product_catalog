package com.example.backend.controllers;

import com.example.backend.domain.dto.CategoryCreateDto;
import com.example.backend.service.CategoryService;
import com.example.backend.domain.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    final CategoryService categoryService;

    /**
     * Сохранить категорию
     *
     * @param categoryCreateDto Параметры категории
     */
    @PostMapping("/save")
    public Category save(CategoryCreateDto categoryCreateDto) {
        return categoryService.saveCategory(categoryCreateDto);
    }

    /**
     * Получить все записи по категриям
     */
    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }
}
