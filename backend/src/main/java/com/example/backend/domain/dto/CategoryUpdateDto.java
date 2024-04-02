package com.example.backend.domain.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class CategoryUpdateDto {

    /**
     * Id категории
     */
    @NotNull(message = "ID не должно быть пустым")
    private Integer id;

    /**
     * Название категории
     */
    @NotNull(message = "Название не должно быть пустым")
    private String name;

    /**
     * Описание категории
     */
    @NotNull(message = "Описание не должно быть пустым")
    private String description;

}
