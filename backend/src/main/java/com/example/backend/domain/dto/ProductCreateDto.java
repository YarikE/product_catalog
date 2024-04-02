package com.example.backend.domain.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductCreateDto {

    /**
     * Название продукта
     */
    @NotNull(message = "Название не должно быть пустым")
    private String    name;

    /**
     * Описание продукта
     */
    @NotNull(message = "Описание не должно быть пустым")
    private String    description;

    /**
     * Цена продукта
     */
    @NotNull(message = "Цена не должна быть пустым")
    private double    price;

    /**
     * ID изображения продукта
     */
    @Nullable
    private String    image_id;

    /**
     * ID категории продукта
     */
    @NotNull(message = "Категория должна быть выбрана")
    private Integer    category_id;

    /**
     * Дата добавления продукта
     */
    @NotNull(message = "Дата добавления товара не должна быть пустой")
    private LocalDate add_date;

    /**
     * Статус продукта
     */
    @NotNull(message = "Статус не должен быть пустым")
    private Boolean   status;
}
