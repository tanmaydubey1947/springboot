package com.springboot.service.scheduler;


import com.springboot.dao.OrderRepository;
import com.springboot.dto.scheduler.Order;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @PostConstruct
    public void initDataToDB() {

        List<Order> orders = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> new Order("Order" + i, new Random(5).nextInt(), new Random().nextDouble()))
                .collect(Collectors.toList());

        orderRepository.saveAll(orders);
    }


    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
