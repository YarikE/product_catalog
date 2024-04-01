package com.example.backend.domain.dto;

import lombok.Getter;

/**
 * Дто данных для обновления статуса продукта
 */
@Getter
public class UpdateProductStatusDto {

    public Long productId;
    public Boolean status;
}
