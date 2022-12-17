package com.personal.project.springbootdockerdemo;


import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  private final KafkaTemplate<String,String> kafkaTemplate;

  public DemoController(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }


  @GetMapping("/hello")
  public String hello(){
    return "hello world!!!";
  }



  @GetMapping("/publish")
  public void publish(){
    kafkaTemplate.send("hello-world","hello","{}");
  }

}
