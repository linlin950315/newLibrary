package com.example.library.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//import io.swagger.v3.oas.annotations.extensions.Extension;

@ControllerAdvice // 向客户端抛出实际错误
public class ApiExceptionHandler {
    // ResponseEntity：This can also be used in Spring MVC as the return value from
    // an @Controller method:
    @ExceptionHandler(value = { ApiRequestException.class })
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        // 1.create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(e.getMessage(),
                // e,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));
        // 2.return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}
