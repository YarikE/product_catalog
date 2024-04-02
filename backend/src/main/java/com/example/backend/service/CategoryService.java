package com.example.backend.service;

import com.example.backend.controllers.customExceptions.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.backend.domain.entity.Product;
import com.example.backend.domain.entity.Category;
import com.example.backend.domain.dto.CategoryCreateDto;
import com.example.backend.domain.dto.CategoryUpdateDto;

import com.example.backend.repository.ProductRepository;
import com.example.backend.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    /** Репозиторй категорий */
    private final CategoryRepository categoryRepository;

    /** Репозиторий продуктов */
    private final ProductRepository productRepository;

    /**
     * Получить категорию по ID
     *
     * @param id ID категории
     */
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    /**
     * Сохранить категорию
     *
     * @param categoryCreateDto ДТО Категории
     */
    public void saveCategory(CategoryCreateDto categoryCreateDto) {
        Category category = new Category()
                .setName(categoryCreateDto.getName())
                .setDescription(categoryCreateDto.getDescription());

        categoryRepository.save(category);
    }

    /**
     * Получить все записи по категориям
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Удалить категорию по ID
     *
     * @param id ID категории
     */
    public Boolean deleteCategoryById(Integer id) {
        try {
            Category category = categoryRepository.findById(id).get();
            List<Product> products = productRepository.findByCategory(category);

            for (Product product : products) {
                product.setStatus(false);
                productRepository.save(product);
            }

            categoryRepository.delete(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Редактировать категорию
     *
     * @param categoryDto Обновленные параметры категории
     */
    public void editCategory(CategoryUpdateDto categoryDto) throws CustomException {
        try {

            Category category = categoryRepository.findById(categoryDto.getId()).get();
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            categoryRepository.save(category);

        } catch (Exception e) {
            throw new CustomException("Ошибка сервера: не получилось обновить категорию");
        }
    }
}
