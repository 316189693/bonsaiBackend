package com.bonsai.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bonsai")
public class BonsaiApplication {
  public static void main(String[] args) {
    SpringApplication.run(BonsaiApplication.class, args);
  }
}
