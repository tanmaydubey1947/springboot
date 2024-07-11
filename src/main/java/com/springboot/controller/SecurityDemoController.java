package com.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello on /welcome context";
    }


    @GetMapping("/greeting")
    public String greeting() {
        return "Hello on /greeting context";
    }


    @GetMapping("/nonSecure")
    public String nonSecure() {
        return "Hello on /nonSecure context";
    }



}
