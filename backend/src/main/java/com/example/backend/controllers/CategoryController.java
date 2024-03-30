package com.example.backend.controllers;

import com.example.backend.domain.dto.CategoryDto;
import com.example.backend.service.CategoryService;
import com.example.backend.domain.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    final CategoryService categoryService;

    /**
     * Сохранить категорию
     *
     * @param categoryDto Параметры категории
     */
    @PostMapping("/save")
    public Category save(CategoryDto categoryDto) {
        return categoryService.saveCategory(categoryDto);
    }
}
