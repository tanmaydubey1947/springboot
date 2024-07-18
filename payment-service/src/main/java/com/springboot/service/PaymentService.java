package com.springboot.service;

import com.springboot.entity.Payment;
import com.springboot.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

    public Payment getByOrderId(String orderId) {
        return repository.findByOrderId(orderId);
    }
}