package com.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.backend.domain.entity.Product;
import com.example.backend.domain.dto.ProductDto;
import com.example.backend.domain.entity.Category;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    /**
     * Сохранить продукт
     *
     * @param productDto Параметры продукта
     */
    public Product save(ProductDto productDto) {
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

    /**
     * Найти все продукты
     */
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Удалить запись о продукте по ID
     *
     * @param id ID продукта
     */
    public Boolean deleteById(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Установить статус
     *
     * @param id Id продукта
     * @param status Статус продукта
     */
    public Boolean setProductStatus(Long id, Boolean status) {
//        try {
            Product product =  productRepository.findById(id).orElse(null);
            if (product == null) {
                return false;
            }
            product.setStatus(status);
            productRepository.save(product);

            return true;
//        } catch (Exception e) {
//            return false;
//        }
    }
}
