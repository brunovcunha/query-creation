package com.iftm.query_creation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class QueryCreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryCreationApplication.class, args);
	}

}
