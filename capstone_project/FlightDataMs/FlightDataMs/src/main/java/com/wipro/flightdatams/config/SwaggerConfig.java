package com.wipro.flightdatams.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
    public OpenAPI flightDataMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Flight Data Microservice API")
                        .description("API documentation for Flight Data Management System")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Wipro Team")
                                .email("support@wipro.com")));
    }
}
