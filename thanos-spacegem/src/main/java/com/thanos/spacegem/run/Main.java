package com.thanos.spacegem.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by qiliang on 2018/9/9.
 */
@SpringBootApplication(scanBasePackages = {"com.thanos.spacegem"})
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
