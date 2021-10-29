package com.jab.microservices.infrastructure.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CAController {

    private Logger logger = LoggerFactory.getLogger(CAController.class);

    private record GlobalErrorResponse(String message) {}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorResponse> handleException(Exception ex) {

        logger.error(ex.getLocalizedMessage(), ex);

        String message = "Contact with the operator";
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new GlobalErrorResponse(message));
    }

}