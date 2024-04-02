package com.example.backend.domain.entity;

import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.experimental.Accessors;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Accessors(chain = true)
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String  name;
    private String  description;
}
