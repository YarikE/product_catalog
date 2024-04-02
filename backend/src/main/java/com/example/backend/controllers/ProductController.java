package com.example.backend.controllers;

import com.example.backend.controllers.validator.Validator;
import com.example.backend.domain.dto.ProductUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.backend.domain.dto.ProductCreateDto;
import com.example.backend.domain.entity.Product;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.backend.service.ProductService;
import com.example.backend.domain.dto.ProductUpdateStatusDto;
import com.example.backend.core.response.BaseResponseDto;
import com.example.backend.controllers.customExceptions.CustomException;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Сохранить продукт
     *
     * @param productCreateDto Параметры продукта
     */
    @PostMapping("/save")
    public BaseResponseDto saveProduct(@Valid @RequestBody ProductCreateDto productCreateDto, BindingResult result) throws CustomException {

        if (result.hasErrors()) {
            return Validator.validate(result);
        }

        productService.save(productCreateDto);

        return (new BaseResponseDto()).setStatus(true).setMessage("Продукт успешно сохранен");
    }

    /**
     * Получить все записи о продуктах
     */
    @GetMapping("/all")
    public List<Product> getAllProducts() throws CustomException {
        return productService.findAll();
    }

    /**
     * Удалить продукт
     *
     * @param id ID продукта
     */
    @DeleteMapping("/delete/{id}")
    public BaseResponseDto deleteProduct(@PathVariable Integer id) throws CustomException {

        BaseResponseDto response = new BaseResponseDto();
        productService.deleteById(id);

        return response.setMessage("Запись успешно удалена").setStatus(true);
    }

    /**
     * Обновить статус продукта
     *
     * @param productDto Данные обновления статуса продукта
     */
    @PostMapping("/update-status")
    public BaseResponseDto updateProductStatus(@Valid @RequestBody ProductUpdateStatusDto productDto, BindingResult result) throws CustomException {

        if (result.hasErrors()) {
            return Validator.validate(result);
        }

        BaseResponseDto response = new BaseResponseDto();
        productService.setProductStatus(productDto.getProductId(), productDto.getStatus());

        return response.setMessage("Статус продукта успешно обновлен").setStatus(true);
    }

    /**
     * Отредактировать продукт
     *
     * @param productDto Параметры редактирования продукта
     */
    @PostMapping("/update")
    public BaseResponseDto updateProduct(@Valid @RequestBody ProductUpdateDto productDto, BindingResult result) throws CustomException {

        if (result.hasErrors()) {
            return Validator.validate(result);
        }

        productService.editProduct(productDto);

        return (new BaseResponseDto()).setStatus(true).setMessage("Продукт успешно обновлен");
    }

    /**
     * Получить отфильтрованный по полю список продуктов
     *
     * @param fieldName Имя поля
     * @param filterValue Значение поля
     */
    @GetMapping("/get-filtered")
    public List<Product> getProductsFilteredByField(@RequestParam(required = false) String fieldName, @RequestParam(required = false) String filterValue) throws CustomException {
        if(fieldName != null && filterValue != null) {
            return productService.getProductsFilteredByField(fieldName, filterValue);
        } else {
            return productService.findAll();
        }
    }
}
