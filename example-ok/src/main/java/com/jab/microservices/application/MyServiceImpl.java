package com.jab.microservices.application;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    @Override
    public String service(Integer id) {

        if(id == 1) {
            return "Hello, World";
        }

        throw new RuntimeException("Katakroker");
    }
}
