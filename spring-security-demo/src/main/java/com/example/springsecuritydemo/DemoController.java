package com.example.springsecuritydemo;

/**
 * @author sahil.sharma
 */
public class DemoController {

  public static void main(String[] args) {

    ParentClass<?> p = ParentClass.builder().build();

    String s = (String)p.getMessage();
  }
}
