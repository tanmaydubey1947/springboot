package com.springboot.dto;

import com.springboot.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO {

    private Order order;
    private PaymentDTO paymentResponse;
    private UserDTO userInfo;

}