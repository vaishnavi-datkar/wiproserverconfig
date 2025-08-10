package com.wipro.secondboot;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.boot.SpringApplication;
/*import org.springframework.boot.autoconfigure.AutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("com.wipro.secondboot")
@Configuration
@AutoConfiguration */
@SpringBootApplication
public class SecondbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondbootApplication.class, args);
	}

}
