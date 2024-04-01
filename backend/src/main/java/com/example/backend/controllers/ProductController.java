package com.example.backend.controllers;

import lombok.RequiredArgsConstructor;
import com.example.backend.domain.dto.ProductDto;
import com.example.backend.domain.entity.Product;
import org.springframework.web.bind.annotation.*;
import com.example.backend.service.ProductService;
import com.example.backend.domain.dto.UpdateProductStatusDto;
import com.example.backend.domain.dto.response.BaseResponseDto;
import com.example.backend.controllers.customException.CustomException;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Сохранить продукт
     *
     * @param productDto Параметры продукта
     */
    @PostMapping("/save")
    public Product saveProduct(@RequestBody ProductDto productDto) throws CustomException {

        if (productDto.getCategory_id() == null) {
            throw new CustomException("У товара должна быть категория");
        }

        return productService.save(productDto);
    }

    /**
     * Получить все записи о продуктах
     */
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    /**
     * Удалить продукт
     *
     * @param id ID продукта
     */
    @DeleteMapping("/delete/{id}")
    public BaseResponseDto deleteProduct(@PathVariable Long id) {
        BaseResponseDto response = new BaseResponseDto();

        Boolean result = productService.deleteById(id);

        if (result) {
            response.setMessage("Запись успешно удалена").setStatus(true);
        } else {
            response.setMessage("Не удалось удалить запись").setStatus(false);
        }

        return response;
    }

    /**
     * Обновить статус продукта
     *
     * @param productDto Данные обновления статуса продукта
     */
    @PostMapping("/update-status")
    public BaseResponseDto updateProductStatus(@RequestBody UpdateProductStatusDto productDto) {
        BaseResponseDto response = new BaseResponseDto();

        Boolean result = productService.setProductStatus(productDto.getProductId(), productDto.getStatus());

        if (result) {
            response.setMessage("Статус продукта успешно обновлен").setStatus(true);
        } else {
            response.setMessage("Не удалось обновить статус продукта").setStatus(false);
        }

        return response;
    }
}
