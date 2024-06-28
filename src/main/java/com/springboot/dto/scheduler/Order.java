package com.springboot.dto.scheduler;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ORDER_TABLE")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int qty;
    private double price;

    public Order(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}
