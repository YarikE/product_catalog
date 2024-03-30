package com.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.backend.domain.entity.Product;
import com.example.backend.domain.dto.ProductDto;
import com.example.backend.domain.entity.Category;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public Product save(ProductDto productDto) {
//        Category category = null;
//        if (productDto.getCategory_id() != null) {
//            category = categoryRepository.findById(productDto.getCategory_id()).orElse(null);
//        }

        Category category = categoryRepository.findById(productDto.getCategory_id()).orElse(null);

        Product product = new Product()
                .setName(productDto.getName())
                .setDescription(productDto.getDescription())
                .setPrice(productDto.getPrice())
                .setImage_id(productDto.getImage_id())
                .setCategory(category)
                .setAdd_date(productDto.getAdd_date())
                .setStatus(productDto.getStatus());

        return productRepository.save(product);
    }
}
