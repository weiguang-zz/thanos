package com.thanos.spacegem.core;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 * @author qiliang
 * @date 2018/9/9
 */
@Component
@Order(value = 1)
public class SendExecutor implements ApplicationRunner {

  @Resource
  private KafkaProducerService kafkaProducerService;

  @Override
  public void run(ApplicationArguments applicationArguments) throws Exception {
    kafkaProducerService.send();
  }
}
