package com.thanos.portal.autoconfig;

import com.thanos.portal.domain.identity.PermissionPointBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.thanos.portal.domain")
public class MongoAutoConfig {

  @Bean
  public PermissionPointBeanPostProcessor permissionPointBeanPostProcessor(){
    return new PermissionPointBeanPostProcessor();
  }


  @Bean
  MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
    return new MongoTransactionManager(dbFactory);
  }

}
