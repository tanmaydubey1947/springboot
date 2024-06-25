package com.springboot.controller;

import com.springboot.dto.EmailRequest;
import com.springboot.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/sendEmail")
    public String sendEmailText(@RequestBody EmailRequest emailRequest) {
        return emailService.sendSimpleEmail(emailRequest);
    }
}
