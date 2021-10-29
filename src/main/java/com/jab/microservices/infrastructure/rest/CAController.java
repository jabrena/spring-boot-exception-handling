package com.jab.microservices.infrastructure.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class CAController {

    private Logger logger = LoggerFactory.getLogger(CAController.class);

    //private record GlobalErrorResponse(String message) {}

    private class GlobalErrorResponse {
        private String message;

        public GlobalErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GlobalErrorResponse that = (GlobalErrorResponse) o;
            return Objects.equals(message, that.message);
        }

        @Override
        public int hashCode() {
            return Objects.hash(message);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorResponse> handleException(Exception ex) {

        logger.error(ex.getLocalizedMessage(), ex);

        String message = "Contact with the operator";
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new GlobalErrorResponse(message));
    }

}