package com.example.demo;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Timed("lightAPI")
    @GetMapping("/light")
    public ResponseEntity<Void> light() {
        throw new RuntimeException("error");
        //return new ResponseEntity<>(HttpStatus.OK);
    }

    @Timed("heavyAPI")
    @GetMapping("/heavy")
    public ResponseEntity<Void> heavy() throws InterruptedException {
        Thread.sleep(924);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
