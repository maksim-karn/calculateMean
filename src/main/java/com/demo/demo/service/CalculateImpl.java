package com.demo.demo.service;

import com.demo.demo.entity.TimeAndNumberPair;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculateImpl implements Calculate {

  private final Deque<TimeAndNumberPair> values = new ArrayDeque<>();
  private final int minutesInterval = 5;

  public void accept(int number) {
    values.addFirst(new TimeAndNumberPair(LocalDateTime.now(), number));
  }

  public double mean() {
    List<Integer> numbers = new ArrayList<>();
    LocalDateTime timeEnd = LocalDateTime.now().minusMinutes(minutesInterval);

    Iterator<TimeAndNumberPair> iterator = values.iterator();
    while (iterator.hasNext()) {
      TimeAndNumberPair numberPair = iterator.next();
      if (numberPair.getLocalDateTime().isAfter(timeEnd)) {
        numbers.add(numberPair.getNumber());
      } else {
        break;
      }
    }
    return numbers.stream().collect(Collectors.summarizingInt(Integer::intValue)).getAverage();
  }
}
