package com.example.springsecuritydemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author sahil.sharma
 */
@SuperBuilder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ChildClass{
  private String hello;
  private String world;
  private long quantity;
}
