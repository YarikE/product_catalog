package com.example.backend.domain.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "images")
public class Image {
    @Id
    private String id;

    private Binary image;
}