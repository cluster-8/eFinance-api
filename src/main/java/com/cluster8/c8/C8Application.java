package com.cluster8.c8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class C8Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(C8Application.class);

		app.run(args);
	}
}
