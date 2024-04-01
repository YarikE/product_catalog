package com.example.backend.service;

import com.example.backend.domain.dto.ProductUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.backend.domain.entity.Product;
import com.example.backend.domain.dto.ProductCreateDto;
import com.example.backend.domain.entity.Category;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    /**
     * Сохранить продукт
     *
     * @param productCreateDto Параметры продукта
     */
    public Product save(ProductCreateDto productCreateDto) {
        Category category = categoryRepository.findById(productCreateDto.getCategory_id()).orElse(null);

        Product product = new Product()
                .setName(productCreateDto.getName())
                .setDescription(productCreateDto.getDescription())
                .setPrice(productCreateDto.getPrice())
                .setImage_id(productCreateDto.getImage_id())
                .setCategory(category)
                .setAdd_date(productCreateDto.getAdd_date())
                .setStatus(productCreateDto.getStatus());

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
        try {
            Product product =  productRepository.findById(id).orElse(null);
            if (product == null) {
                return false;
            }
            product.setStatus(status);
            productRepository.save(product);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Отредактировать запись о продукте
     *
     * @param productUpdateDto Параметры для редактирования
     */
    public Boolean editProduct(ProductUpdateDto productUpdateDto) {
        try {
            Product product = productRepository.findById(productUpdateDto.getId()).orElse(null);

            if (product == null) {
                return false;
            }

            Category category = categoryRepository.findById(productUpdateDto.getCategory_id()).orElse(null);

            product.setName(productUpdateDto.getName());
            product.setDescription(productUpdateDto.getDescription());
            product.setPrice(productUpdateDto.getPrice());
            product.setImage_id(productUpdateDto.getImage_id());
            product.setCategory(category);
            product.setAdd_date(productUpdateDto.getAdd_date());
            product.setStatus(productUpdateDto.getStatus());

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
