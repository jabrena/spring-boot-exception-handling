package com.jab.microservices.application;

public sealed interface ServiceResult permits
        ServiceResult.ResultSuccess,
        ServiceResult.ResultError {

    record ResultSuccess (String result) implements ServiceResult { }
    record ResultError (String message) implements ServiceResult { }
}