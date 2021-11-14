package com.jab.microservices.infrastructure.rest;

import com.jab.microservices.application.MySealedService;
import com.jab.microservices.application.MyService;
import com.jab.microservices.application.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/sealed",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SealedController {

    Logger logger = LoggerFactory.getLogger(SealedController.class);

    private MySealedService myService;

    public SealedController(MySealedService myService) {
        this.myService = myService;
    }

    @GetMapping("resource")
    public @ResponseBody ResponseEntity<OkResponse> resource(@RequestParam Integer id) {

        //Current implementation: https://openjdk.java.net/jeps/375
        //Waiting for Java 18: https://openjdk.java.net/jeps/420
        var result = myService.service(id);
        if (result instanceof ServiceResult.ResultSuccess resultOk) {
            return ResponseEntity.ok().body(new OkResponse(resultOk.result()));
        } else if (result instanceof ServiceResult.ResultError resultKo) {
            logger.warn(resultKo.message());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
