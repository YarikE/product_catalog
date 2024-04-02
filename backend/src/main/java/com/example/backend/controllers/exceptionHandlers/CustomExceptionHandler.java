package com.example.backend.controllers.exceptionHandlers;

import com.example.backend.core.response.BaseResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.backend.controllers.customExceptions.CustomException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public BaseResponseDto handleCustomException(CustomException e) {

        return (new BaseResponseDto())
            .setMessage(e.getMessage())
            .setStatus(false);
    }
}
