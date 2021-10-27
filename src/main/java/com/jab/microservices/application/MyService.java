package com.jab.microservices.application;

public interface MyService {
    String service(Integer id);
    String service2() throws MyGOTOException;
}
