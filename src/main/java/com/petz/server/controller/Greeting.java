package com.petz.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/say")
public class Greeting {
    @GetMapping("/hello")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello");
    }
}

