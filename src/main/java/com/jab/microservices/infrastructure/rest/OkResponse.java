package com.jab.microservices.infrastructure.rest;

//record OkResponse(String message) { }

import java.util.Objects;

public class OkResponse {

    private String message;

    public OkResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OkResponse that = (OkResponse) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
