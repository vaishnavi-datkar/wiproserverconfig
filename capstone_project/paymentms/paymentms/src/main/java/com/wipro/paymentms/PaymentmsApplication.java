package com.wipro.paymentms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentmsApplication.class, args);
		System.out.println("========================================");
        System.out.println("PaymentMS Started Successfully!");
        System.out.println("Port: 9092");
        System.out.println("Swagger UI: http://localhost:9092/swagger-ui.html");
        System.out.println("========================================");
	}

}
