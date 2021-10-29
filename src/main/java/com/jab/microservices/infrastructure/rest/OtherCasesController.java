package com.jab.microservices.infrastructure.rest;


//import lombok.SneakyThrows;
import com.jab.microservices.application.MyTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/other",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class OtherCasesController {

    @GetMapping("/resource1")
    public @ResponseBody ResponseEntity<String> resource1() throws InterruptedException {
        throw new InterruptedException();
    }

    @GetMapping("/resource2")
    public @ResponseBody ResponseEntity<String> resource2() throws InterruptedException {

        MyTask task = new MyTask();
        task.run();

        return ResponseEntity.ok().build();
    }
}
