package com.learn.springaop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration

public class SwaggerConfig {

	@Bean

	public OpenAPI openAPI() {

		return new OpenAPI()

				.info(new Info()

						.title("Spring AOP Product API")

						.description("REST API with Spring Boot, AOP, JUnit, JaCoCo, SonarQube")

						.version("1.0.0"));

	}

}
