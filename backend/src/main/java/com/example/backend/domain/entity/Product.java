package com.example.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.annotation.Nullable;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Data
@Accessors(chain = true)
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long  id;

    private String  name;

    private String  description;

    private double  price;

    private String  image_id;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    private LocalDate add_date;

    private Boolean status;
}
