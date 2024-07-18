package com.springboot.controller;

import com.springboot.dto.OrderResponseDTO;
import com.springboot.entity.Order;
import com.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    //Validation
    //logging
    //Exception handling
    @PostMapping
    public String placeNewOrder(@RequestBody Order order) {
        return service.placeAnOrder(order);
    }

    @GetMapping("/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable String orderId) {
        return service.getOrder(orderId);
    }

}