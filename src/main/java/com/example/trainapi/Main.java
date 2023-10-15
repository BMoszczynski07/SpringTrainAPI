package com.example.trainapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Main {
    @RequestMapping("/")
    public String handleWelcome() {
        return "Welcome to the train CRUD App!";
    }
}
