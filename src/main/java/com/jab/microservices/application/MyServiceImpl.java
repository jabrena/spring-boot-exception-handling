package com.jab.microservices.application;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    @Override
    public String ok() {
        return "Hello, World";
    }

    @Override
    public String ko() {
        throw new RuntimeException("Katakroker");
    }

    @Override
    public String ko2() throws MyGOTOException {
        throw new MyGOTOException("Legacy Katakroker");
    }
}
