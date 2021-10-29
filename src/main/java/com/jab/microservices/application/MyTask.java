package com.jab.microservices.application;

import lombok.SneakyThrows;

public class MyTask implements Runnable {

    @Override
    @SneakyThrows
    public void run() {
        throw new InterruptedException();
    }
}
