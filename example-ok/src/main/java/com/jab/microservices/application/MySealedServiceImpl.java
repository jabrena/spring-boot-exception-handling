package com.jab.microservices.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MySealedServiceImpl implements MySealedService {

    private Logger logger = LoggerFactory.getLogger(MySealedServiceImpl.class);

    @Override
    public Result serviceMethod(Integer id) {

        if(id == 1) {
            return new Result.Success("Hello, World");
        } else if (id == 2) {
            return new Result.Error("Katakroker");
        }

        return new Result.Error("Katakroker");
    }
}
