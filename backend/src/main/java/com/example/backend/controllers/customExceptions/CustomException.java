package com.example.backend.controllers.customExceptions;

/**
 * Класс исключения
 */
public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }
}
