package com.demo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TimeAndNumberPair {
  private LocalDateTime localDateTime;
  private int number;
}
