package com.example.springsecuritydemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sahil.sharma
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParentClass<T> {
  private Long id;
  private String name;
  private T message;


}
