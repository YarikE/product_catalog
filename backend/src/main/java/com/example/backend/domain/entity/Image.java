package com.example.backend.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "images")
public class Image {
    @Id
    private String id;
    private Binary image;
}