package com.demo.demo;

import com.demo.demo.service.Calculate;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

@SpringBootApplication
@EnableScheduling
@AllArgsConstructor
public class DemoApplication {

  private final Calculate calculate;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Scheduled(fixedDelay = 1000)
  public void callAccept() {
    int randomisedInt = new Random().nextInt(10000);
    calculate.accept(randomisedInt);
  }

  @Scheduled(fixedDelay = 1000)
  public double callMean() {
    double average = calculate.mean();
    System.out.println("Average: " + average);
    return average;
  }
}
