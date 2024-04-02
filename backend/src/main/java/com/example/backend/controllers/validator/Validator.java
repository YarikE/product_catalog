package com.example.backend.controllers.validator;

import com.example.backend.core.response.BaseResponseDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class Validator {

    public static BaseResponseDto validate(BindingResult result) {

        List<FieldError> errors = result.getFieldErrors();

        BaseResponseDto responseDto = new BaseResponseDto();

        for (FieldError error : errors) {
            responseDto.setStatus(false).setMessage(error.getDefaultMessage());
        }

        return responseDto;
    }
}
