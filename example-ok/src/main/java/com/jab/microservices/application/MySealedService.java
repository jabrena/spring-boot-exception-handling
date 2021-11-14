package com.jab.microservices.application;

public interface MySealedService {

    sealed interface Result permits Result.Success, Result.Error {
        record Success (String result) implements Result { }
        record Error (String rootCause) implements Result { }
    }

    Result serviceMethod(Integer id);
}
