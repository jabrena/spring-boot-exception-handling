package com.jab.microservices.infrastructure.rest;

import com.jab.microservices.application.MyOptionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/optional",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class OptionalController {

    private MyOptionalService myService;

    public OptionalController(MyOptionalService myService) {
        this.myService = myService;
    }

    @GetMapping("resource")
    public @ResponseBody ResponseEntity<OkResponse> resource(@RequestParam Integer id) {
        return toOkResponse(myService.service(id));
    }

    private ResponseEntity<OkResponse> toOkResponse(Optional<String> response) {
        return response
                .map(value -> ResponseEntity.ok().body(new OkResponse(value)))
                .orElse(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }
}
