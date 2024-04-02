package com.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.backend.domain.entity.Product;
import com.example.backend.domain.entity.Category;
import com.example.backend.domain.dto.ProductCreateDto;
import com.example.backend.domain.dto.ProductUpdateDto;
import com.example.backend.repository.ProductRepository;
import com.example.backend.repository.CategoryRepository;

import com.example.backend.controllers.customExceptions.CustomException;

import java.util.List;
import java.time.LocalDate;
import java.util.Collections;

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
    public void save(ProductCreateDto productCreateDto) throws CustomException {

        Category category = categoryRepository.findById(productCreateDto.getCategory_id()).orElse(null);

        if (category == null) {
            throw new CustomException("Такой категории не существует");
        }

        try {
            Product product = new Product()
                    .setName(productCreateDto.getName())
                    .setDescription(productCreateDto.getDescription())
                    .setPrice(productCreateDto.getPrice())
                    .setImage_id(productCreateDto.getImage_id())
                    .setCategory(category)
                    .setAdd_date(productCreateDto.getAdd_date())
                    .setStatus(productCreateDto.getStatus());

            productRepository.save(product);
        } catch (Exception e) {
            throw new CustomException("Ошибка сервера:  Не удалось сохранить");
        }

    }

    /**
     * Найти все продукты
     */
    public List<Product> findAll() throws CustomException {

        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new CustomException("Ошибка сервера:  Не удалось получить все продукты");
        }
    }

    /**
     * Удалить запись о продукте по ID
     *
     * @param id ID продукта
     */
    public void deleteById(Integer id) throws CustomException {

        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new CustomException("Ошибка сервера:  Не удалось удалить продукт");
        }
    }

    /**
     * Установить статус
     *
     * @param id Id продукта
     * @param status Статус продукта
     */
    public void setProductStatus(Integer id, Boolean status) throws CustomException {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            throw new CustomException("Продкута с таким ID нет");
        }
        try {
            product.setStatus(status);
            productRepository.save(product);
        } catch (Exception e) {
            throw new CustomException("Ошибка сервера: Не удалось сменить статус");
        }
    }

    /**
     * Отредактировать запись о продукте
     *
     * @param productUpdateDto Параметры для редактирования
     */
    public void editProduct(ProductUpdateDto productUpdateDto) throws CustomException {

        try {
            Product product = productRepository.findById(productUpdateDto.getId()).orElse(null);
            if (product == null) {
                throw new CustomException("Нет продукта с таким id");
            }

            Category category = categoryRepository.findById(productUpdateDto.getCategory_id()).orElse(null);
            if (category == null) {
                throw new CustomException("Нет категории с таким id");
            }

            product.setName(productUpdateDto.getName());
            product.setDescription(productUpdateDto.getDescription());
            product.setPrice(productUpdateDto.getPrice());
            product.setImage_id(productUpdateDto.getImage_id());
            product.setCategory(category);
            product.setAdd_date(productUpdateDto.getAdd_date());
            product.setStatus(productUpdateDto.getStatus());

            productRepository.save(product);

        } catch (Exception e) {

            throw new CustomException("Ошибка сервера: Не удалось отредактировать запись");
        }
    }

    /**
     * Получить список продуктов, отфильтрованный по полю и значению
     *
     * @param fieldName Название поля
     * @param filterValue Значение поля
     */
    public List<Product> getProductsFilteredByField(String fieldName, String filterValue) {

        switch (fieldName) {
            case "name":
                return productRepository.findByName(filterValue);

            case "description":
                return productRepository.findByDescription(filterValue);

            case "price":
                return productRepository.findByPrice(Double.parseDouble(filterValue));

            case "category":
                Category category = categoryRepository.findById(Integer.parseInt(filterValue)).orElse(null);
                if (category == null) {
                    return Collections.emptyList();
                }
                return productRepository.findByCategory(category);

            case "addDate":
                return productRepository.findByAdd_date(LocalDate.parse(filterValue));

            case "status":
                return productRepository.findByStatus(Boolean.valueOf(filterValue));

            default:
                return Collections.emptyList();
        }
    }
}
