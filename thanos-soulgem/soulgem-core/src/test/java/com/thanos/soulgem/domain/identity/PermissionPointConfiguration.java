package com.thanos.soulgem.domain.identity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by zhangzheng on 8/31/18
 * Email:zhangzheng@youzan.com
 */
@Configuration
public class PermissionPointConfiguration {

  @Bean
  public TestBean testBean(){
    return new TestBean();
  }

  static class TestBean{
    @PermissionPoint(name = "somePermissionName", group = PermissionGroup.Equipment)
    public void someMethod(String someString){

    }

  }

}
