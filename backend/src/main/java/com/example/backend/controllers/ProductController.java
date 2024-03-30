package com.example.backend.controllers;

import com.example.backend.controllers.customException.CustomException;
import lombok.RequiredArgsConstructor;
import com.example.backend.domain.dto.ProductDto;
import com.example.backend.domain.entity.Product;
import com.example.backend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
