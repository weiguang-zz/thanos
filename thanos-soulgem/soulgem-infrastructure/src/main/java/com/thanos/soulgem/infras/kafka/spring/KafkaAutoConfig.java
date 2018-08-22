package com.thanos.soulgem.infras.kafka.spring;

import com.thanos.soulgem.domain.monitor.FetchRealtimeDataService;
import com.thanos.soulgem.infras.kafka.FetchRealtimeDataFromKafka;
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
  public FetchRealtimeDataService fetchRealtimeDataService(){
    return new FetchRealtimeDataFromKafka();
  }


}
