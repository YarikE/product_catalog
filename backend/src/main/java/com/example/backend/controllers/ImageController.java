package com.example.backend.controllers;

import com.example.backend.domain.entity.Image;
import com.example.backend.service.ImagesService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImagesService saveImagesService;

    @PostMapping
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return saveImagesService.addImage(file);
    }

    @GetMapping("/{id}")
    public Image getImage(@PathVariable String id) {
        return saveImagesService.getImage(id);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
