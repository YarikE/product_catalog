package com.example.backend.controllers.customException;

/**
 * Класс исключения
 */
public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }
}
