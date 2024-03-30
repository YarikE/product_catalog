package com.example.backend.controllers.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.backend.domain.dto.response.BaseResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.backend.controllers.customException.CustomException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException e) {

        BaseResponseDto responseDto = new BaseResponseDto()
            .setMessage(e.getMessage())
            .setStatus(false);

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
