package com.jab.microservices.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyOptionalServiceImpl implements MyOptionalService {

    private Logger logger = LoggerFactory.getLogger(MyOptionalServiceImpl.class);

    @Override
    public Optional<String> service(Integer id) {

        if(id == 1) {
            return Optional.of("Hello, World");
        } else if (id == 2) {
            try {
                throw new RuntimeException("Katakroker");
            } catch (RuntimeException ex) {
                logger.warn("Katakroker managed");
                return Optional.empty();
            }
        }

        throw new RuntimeException("Katakroker");
    }

    @Override
    public Optional<String> service2() throws MyGOTOException {
        throw new MyGOTOException("Legacy Katakroker");
    }
}
