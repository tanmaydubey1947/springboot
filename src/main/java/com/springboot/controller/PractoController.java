package com.springboot.controller;


import com.springboot.dto.PatientAppointmentRequest;
import com.springboot.service.PractoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practo")
public class PractoController {


    @Autowired
    private PractoService practoService;


    @PostMapping
    public String bookDoctorsAppointment(@RequestBody PatientAppointmentRequest request) {
        return practoService.bookAppointment(request);
    }
}
