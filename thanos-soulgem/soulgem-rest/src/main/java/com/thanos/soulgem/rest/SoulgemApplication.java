package com.thanos.soulgem.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@SpringBootApplication(scanBasePackages = "com.thanos.soulgem")
public class SoulgemApplication {

  public static void main(String[] args) {
    SpringApplication.run(SoulgemApplication.class, args);
  }

}
