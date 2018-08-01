package com.thanos.soulgem.autoconfig;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.thanos.soulgem.domain.common.DateRecordAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.thanos.soulgem.domain")
public class MongoAutoConfig {



}
