package com.example.detail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailController {

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/port")
    public ResponseEntity<?> getDetails() {
        return new ResponseEntity<>("detail service port is " + serverPort, HttpStatus.OK);
    }
}
