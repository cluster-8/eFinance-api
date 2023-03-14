package com.cluster8.c8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class C8Controller {

  @GetMapping("/")
  public String main() {
    return "Hello World";
  }
}
