package com.example.backend.service;

import com.example.backend.domain.entity.Image;
import com.example.backend.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImagesService {

    private final ImageRepository imageRepository;

    /**
     * Сохранить изображение
     *
     * @param file Файл (Изображение) для сохранения
     * @return String
     * @throws IOException Exception
     */
    public String addImage(MultipartFile file) throws IOException
    {
        Image image = new Image();
        image.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));

        image = imageRepository.insert(image);

        return image.getId();
    }

    /**
     * Получить изображение
     *
     * @param id ID изображения
     * @return Image
     */
    public Image getImage(String id)
    {
        return imageRepository.findById(id).orElse(null);
    }

}