package com.example.backend.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.example.backend.domain.entity.Image;
import com.example.backend.service.ImageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService saveImagesService;

    /**
     * Загрузить изображение в базу
     *
     * @param file Изображение до 16мб
     */
    @PostMapping
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {

        return saveImagesService.addImage(file);
    }

    /**
     * Получить изображение
     *
     * @param id Id изображения
     */
    @GetMapping("/{id}")
    public Image getImage(@PathVariable String id) {

        return saveImagesService.getImage(id);
    }
}
