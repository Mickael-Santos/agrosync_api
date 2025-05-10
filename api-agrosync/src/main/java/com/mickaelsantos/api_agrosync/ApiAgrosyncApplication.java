package com.mickaelsantos.api_agrosync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class ApiAgrosyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAgrosyncApplication.class, args);
	}

}
