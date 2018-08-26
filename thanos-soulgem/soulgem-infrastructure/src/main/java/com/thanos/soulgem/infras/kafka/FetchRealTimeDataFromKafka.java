package com.thanos.soulgem.infras.kafka;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thanos.common.domain.RealTimeData;
import com.thanos.soulgem.domain.monitor.FetchRealTimeDataService;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 */
public class FetchRealTimeDataFromKafka implements FetchRealTimeDataService {

  private BlockingQueue<List<RealTimeData>> queue = new LinkedBlockingDeque<>();
  private Logger logger = LoggerFactory.getLogger(FetchRealTimeDataFromKafka.class);

  private Gson gson = new Gson();
  private Type contentType = new TypeToken<List<RealTimeData>>(){}.getType();

  @Override
  public List<RealTimeData> fetch() {
    try {
      return queue.take();
    } catch (InterruptedException e) {
      logger.error("fetch data error", e);
    }
    return Collections.emptyList();
  }

  @Override
  public List<RealTimeData> fetch(Long timeout, TimeUnit unit) {
    try {
      return queue.poll(timeout,unit);
    } catch (InterruptedException e) {
      logger.error("fetch data error", e);
    }
    return Collections.emptyList();
  }

  @KafkaListener(topics = { "${kafka.topic.real-time-data}" })
  public void dataReceived(ConsumerRecord<String,String> record){
    try{
      String content = record.value();
      List<RealTimeData> data = gson.fromJson(content, contentType);
      queue.add(data);
    } catch (Exception e){
      logger.error("receive data error",e);
    }

  }



}
