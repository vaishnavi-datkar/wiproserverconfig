package com.wipro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.wipro.aop") // Include your aspect and AirTravelProcess here
@EnableAspectJAutoProxy
public class AppConfig {
}
