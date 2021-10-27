package com.jab.microservices.application;

public interface MyService {
    String ok();
    String ko();
    String ko2() throws MyGOTOException;
}
