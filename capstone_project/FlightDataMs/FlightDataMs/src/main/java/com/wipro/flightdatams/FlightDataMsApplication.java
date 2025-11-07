package com.wipro.flightdatams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlightDataMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightDataMsApplication.class, args);
		 System.out.println("========================================");
	        System.out.println("FlightDataMS Started Successfully!");
	        System.out.println("Port: 9090");
	        System.out.println("Swagger UI: http://localhost:9090/swagger-ui.html");
	        System.out.println("========================================");
		
	}

}
