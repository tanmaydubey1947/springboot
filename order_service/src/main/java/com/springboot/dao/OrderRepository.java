package com.springboot.dao;

import com.springboot.dto.scheduler.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
