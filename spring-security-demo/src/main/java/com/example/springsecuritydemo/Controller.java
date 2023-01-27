package com.example.springsecuritydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/")
  public String hello(){
    return "Accessible to all";
  }


  @GetMapping("/user")
  public String hello1(){
    return "Accessible to use and admin";
  }


  @GetMapping("/admin")
  public String hello2(){
    return "Accessible to admin only";
  }
}
