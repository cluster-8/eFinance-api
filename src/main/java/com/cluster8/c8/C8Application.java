package com.cluster8.c8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class C8Application {

	public static void main(String[] args) {

		System.getenv().forEach((k, v) -> System.out.println(k + " : " + v));

		SpringApplication app = new SpringApplication(C8Application.class);

		app.run(args);
	}
}
