package com.jab.microservices.application;

public interface MySealedService {

    //Define my types in the interface or isolate in a file
    sealed interface ServiceResult permits
            ServiceResult.ResultSuccess,
            ServiceResult.ResultError {

        record ResultSuccess (String result) implements ServiceResult { }
        record ResultError (String message) implements ServiceResult { }
    }

    ServiceResult service(Integer id);



}
