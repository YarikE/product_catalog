package com.example.backend.domain.dto.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ДТО ответа api
 */
@Getter
public class BaseResponseDto {

    /**
     * Сообщение
     */
    public String message;

    /**
     * Статус
     */
    public Boolean status;

    /**
     * Установить сообщение
     *
     * @param message Сообщение
     */
    public BaseResponseDto setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Установить статус
     *
     * @param status Статус
     */
    public BaseResponseDto setStatus(Boolean status) {
        this.status = status;
        return this;
    }
}
