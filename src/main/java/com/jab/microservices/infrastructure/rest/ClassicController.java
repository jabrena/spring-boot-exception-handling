package com.jab.microservices.infrastructure.rest;

import com.jab.microservices.application.MyGOTOException;
import com.jab.microservices.application.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassicController {

    private record OkResponse(String message) { }

    @Autowired
    private MyService myService;

    @RequestMapping("/api/classic/ok")
    public @ResponseBody ResponseEntity<OkResponse> ok() {
        return toOkResponse(myService.ok());
    }

    @RequestMapping("/api/classic/ko")
    public @ResponseBody ResponseEntity<OkResponse> ko() {
        return toOkResponse(myService.ko());
    }

    //Scenario forced by the Developer
    @RequestMapping("/api/classic/ko2")
    public @ResponseBody ResponseEntity<OkResponse> ko2() throws MyGOTOException {
        return toOkResponse(myService.ko2());
    }

    private ResponseEntity<OkResponse> toOkResponse(String response) {
        return ResponseEntity.ok().body(new OkResponse(response));
    }
}
