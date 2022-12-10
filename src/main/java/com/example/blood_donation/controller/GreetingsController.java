package com.example.blood_donation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/greet")
public class GreetingsController {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello mennnn");
    }

    @GetMapping("/say")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.ok("bayyy mennnn");
    }
}
