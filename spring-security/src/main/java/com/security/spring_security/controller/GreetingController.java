package com.security.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sahil.sharma
 */

@RestController
public class GreetingController {

  @GetMapping("/greet")
  public String greet() {
    return "Hello, World!";
  }
}