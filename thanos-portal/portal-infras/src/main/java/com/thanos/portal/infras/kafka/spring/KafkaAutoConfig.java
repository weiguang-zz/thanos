package com.thanos.portal.infras.kafka.spring;

import com.thanos.portal.domain.monitor.FetchRealTimeDataService;
import com.thanos.portal.infras.kafka.FetchRealTimeDataFromKafka;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 */
@Configuration
@EnableKafka
public class KafkaAutoConfig {

  @Bean
  public FetchRealTimeDataService fetchRealtimeDataService(){
    return new FetchRealTimeDataFromKafka();
  }


}
