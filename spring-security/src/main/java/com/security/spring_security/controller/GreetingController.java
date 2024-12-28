package com.security.spring_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/user")
  public String userEndpoint() {
    return "Hello, World User!";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/admin")
  public String adminEndpoint() {
    return "Hello, World Admin!";
  }


}