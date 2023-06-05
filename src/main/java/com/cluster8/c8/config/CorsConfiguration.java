package com.cluster8.c8.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .exposedHeaders("*")
        .allowedOrigins("http://localhost:8080", "http://localhost:3000", "https://efinance.herokuapp.com",
            "https://e-finance-front-9u47gmp3g-efinance.vercel.app")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
  }
}