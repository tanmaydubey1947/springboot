package com.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.dto.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@KafkaListener(topics = "PAYMENT_TOPIC", groupId = "Payment_consumer_group")
	public void paymentConsumer1(PaymentRequest paymentRequest) throws JsonProcessingException {
		
		log.info("paymentConsumer1 consumed message {} ", new ObjectMapper().writeValueAsString(paymentRequest));
	}

	@KafkaListener(topics = "PAYMENT_TOPIC", groupId = "Payment_consumer_group")
	public void paymentConsumer2(PaymentRequest paymentRequest) throws JsonProcessingException {
		
		log.info("paymentConsumer2 consumed message {} ", new ObjectMapper().writeValueAsString(paymentRequest));
	}

	@KafkaListener(topics = "PAYMENT_TOPIC", groupId = "Payment_consumer_group")
	public void paymentConsumer3(PaymentRequest paymentRequest) throws JsonProcessingException {
		
		log.info("paymentConsumer3 consumed message {} ", new ObjectMapper().writeValueAsString(paymentRequest));
	}

	@KafkaListener(topics = "PAYMENT_TOPIC", groupId = "Payment_consumer_group")
	public void paymentConsumer4(PaymentRequest paymentRequest) throws JsonProcessingException {
		
		log.info("paymentConsumer4 consumed message {} ", new ObjectMapper().writeValueAsString(paymentRequest));
	}

}
