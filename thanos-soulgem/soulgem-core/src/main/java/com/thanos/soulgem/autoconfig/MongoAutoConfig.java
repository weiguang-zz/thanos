package com.thanos.soulgem.autoconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.thanos.soulgem.domain")
public class MongoAutoConfig {



}
