package com.jab.microservices.infrastructure.rest;

import com.jab.microservices.application.MyService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/classic",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ClassicController {

    private MyService myService;

    public ClassicController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("resource")
    public @ResponseBody ResponseEntity<OkResponse> resource(@RequestParam Integer id) {
        return toOkResponse(myService.service(id));
    }

    private ResponseEntity<OkResponse> toOkResponse(String response) {
        return ResponseEntity.ok().body(new OkResponse(response));
    }
}
