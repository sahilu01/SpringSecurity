package com.personal.project.springbootdockerdemo;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@RestController
public class DemoController {

  private final KafkaTemplate<String,String> kafkaTemplate;

  public DemoController(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }


  @GetMapping("/hello")
  public String hello(){
    return "hello!!!!";
  }


  @GetMapping("/publish")
  public String publish(){

    kafkaTemplate.send("hello-world", "hello",
        "{This message is bring sent at" + LocalDate.now() + "}");

    return "Message Sent";
  }
}
