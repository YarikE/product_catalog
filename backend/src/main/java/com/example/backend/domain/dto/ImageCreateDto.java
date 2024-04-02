package com.example.backend.domain.dto;

import lombok.Getter;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

/**
 * Дто создания изображения
 */
@Getter
public class ImageCreateDto {

    @NotNull(message = "Файл должен быть")
    MultipartFile file;
}
