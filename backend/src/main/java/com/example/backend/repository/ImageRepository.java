package com.example.backend.repository;

import com.example.backend.domain.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {}