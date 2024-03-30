package com.example.backend.controllers.customException;

import lombok.Getter;

/**
 * Класс исключения
 */
public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }
}
