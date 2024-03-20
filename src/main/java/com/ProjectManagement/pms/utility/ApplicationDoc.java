package com.ProjectManagement.pms.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {
	@Bean
	Info info() {
		return new Info().title("Product Management System ")
				.description("Restful API with basic crud operation")
				.version("v1.")
				.contact(contact());
	}
	//This is how we document our app
	//dont want to call @openAPIDefinition will automatically take care to swagger
	@Bean
	OpenAPI  openAPI () {
		return new OpenAPI().info(info());
	}

	Contact contact() {
		return new Contact().name("Shreyanka")
				.url("xyz.com")
				.email("xyz@gmail.com");
	}
}
