package com.example.backend.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductUpdateDto {

    public Long      id;
    public String    name;
    public String    description;
    public double    price;
    public String    image_id;
    public String    category_id;
    public LocalDate add_date;
    public Boolean   status;
}
