package com.jab.microservices.application;

import java.util.Optional;

public interface MyOptionalService {
    Optional<String> service(Integer id);
    Optional<String> service2() throws MyGOTOException;
}
