package com.everis.ordersms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrdersMsApplication {

	public static void main(String[] args) {
		System.out.println("Hola mundo");
		SpringApplication.run(OrdersMsApplication.class, args);
	}

}
