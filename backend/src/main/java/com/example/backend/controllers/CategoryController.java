package com.example.backend.controllers;

import com.example.backend.controllers.customExceptions.CustomException;
import com.example.backend.controllers.validator.Validator;
import com.example.backend.domain.dto.CategoryUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import com.example.backend.service.CategoryService;

import com.example.backend.domain.entity.Category;
import com.example.backend.domain.dto.CategoryCreateDto;
import com.example.backend.core.response.BaseResponseDto;

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
    public BaseResponseDto save(@Valid @RequestBody CategoryCreateDto categoryCreateDto, BindingResult result) {

        if (result.hasErrors()) {
            return Validator.validate(result);
        }

        BaseResponseDto responseDto = new BaseResponseDto();
        categoryService.saveCategory(categoryCreateDto);

        return responseDto.setStatus(true).setMessage("Категория успешно сохранена");
    }

    /**
     * Получить все записи по категриям
     */
    @GetMapping("/all")
    public List<Category> getAll() {

        return categoryService.getAllCategories();
    }

    /**
     * Обновить категорию
     *
     * @param categoryUpdateDto Дто с параметрами обновления категории
     * @param result Результат валидирования
     */
    @PostMapping("/update")
    public BaseResponseDto update(@Valid @RequestBody CategoryUpdateDto categoryUpdateDto, BindingResult result) throws CustomException {

        if (result.hasErrors()) {
            return Validator.validate(result);
        }

        categoryService.editCategory(categoryUpdateDto);

        return (new BaseResponseDto()).setStatus(true).setMessage("Категория успешно обновлена");
    }
}
