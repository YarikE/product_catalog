package com.example.backend.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDto {

    /**
     * Название
     */
    private String    name;

    /**
     * Описание
     */
    private String    description;

    /**
     * Цена
     */
    private double    price;

    /**
     * ID изображения
     */
    private String    image_id;

    /**
     * ID категории
     */
    private String    category_id;

    /**
     * Дата добавления
     */
    private LocalDate add_date;

    /**
     * Статус
     */
    private Boolean   status;
}
