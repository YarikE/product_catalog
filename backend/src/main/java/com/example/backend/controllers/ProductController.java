package com.example.backend.controllers;

import lombok.RequiredArgsConstructor;
import com.example.backend.domain.dto.CatDto;
import com.example.backend.domain.entity.Cat;
import com.example.backend.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
public class ProductController {

    private final CatRepository catRepository;

    @Autowired
    public ProductController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @PostMapping("/cat")
    public String createCat(@RequestBody CatDto catDto) {
        Cat cat = new Cat();
        cat.setName(catDto.getName());
        cat.setBirthDay(catDto.getBirthDay());

        catRepository.saveCat(cat);

        return "Cat saved successfully";
    }

}
