package com.example.backend.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductUpdateDto {

    /**
     * Id продукта
     */
    @NotNull(message = "Id продукта не должно быть пустым")
    public Integer   id;

    /**
     * Название продукта
     */
    @NotNull(message = "Название продукта не должно быть пустым")
    public String    name;

    /**
     * Описание продукта
     */
    @NotNull(message = "Описание продукта не должно быть пустым")
    public String    description;

    /**
     * Цена продукта
     */
    @NotNull(message = "Цена продукта не должна быть пустой")
    public double    price;

    /**
     * ID изображения продукта
     */
    @NotNull(message = "ID изображения продукта не должно быть пустым")
    public String    image_id;

    /**
     * ID категории продукта
     */
    @NotNull(message = "ID категории продукта не должно быть пустым")
    public Integer   category_id;

    /**
     * Дата добавления продукта
     */
    @NotNull(message = "Дата добавления продукта не должна быть пустой")
    public LocalDate add_date;

    /**
     * Статус продукта
     */
    @NotNull(message = "Статус продукта не должен быть пустым")
    public Boolean   status;
}
