package com.example.backend.domain.dto;

import lombok.Getter;
import jakarta.validation.constraints.NotNull;

/**
 * Дто данных для обновления статуса продукта
 */
@Getter
public class ProductUpdateStatusDto {

    /**
     * ID продукта
     */
    @NotNull(message = "ID продукта не должно быть пустым")
    public Integer productId;

    /**
     * Статус продукта
     */
    @NotNull(message = "Статус продукта не должен быть пустым")
    public Boolean status;
}
