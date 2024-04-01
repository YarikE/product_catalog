package com.example.backend.service;

import com.example.backend.domain.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.backend.domain.entity.Category;
import com.example.backend.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Получить категорию по ID
     *
     * @param id ID категории
     */
    public Category getCategoryById(String id) {
        return categoryRepository.findById(id).get();
    }

    /**
     * Сохранить категорию
     *
     * @param categoryDto ДТО Категории
     */
    public Category saveCategory(CategoryDto categoryDto) {
        Category category = new Category()
                .setName(categoryDto.getName())
                .setDescription(categoryDto.getDescription());

        return categoryRepository.save(category);
    }

    /**
     * Получить все записи по категориям
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
