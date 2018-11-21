package com.thanos.portal.rest;

import com.thanos.portal.rest.filter.UserAccessFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Create by zhangzheng on 8/31/18
 * Email:zhangzheng@youzan.com
 */
@Configuration
public class WebContextConfiguration {
  @Bean
  @Profile("auth")
  public FilterRegistrationBean userAccessFilter() {
    FilterRegistrationBean filter = new FilterRegistrationBean();
    filter.setFilter(new UserAccessFilter());
    filter.addUrlPatterns("/*");
    return filter;
  }

}
