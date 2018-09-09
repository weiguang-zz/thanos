package com.thanos.spacegem.core;

import com.alibaba.fastjson.JSON;
import com.thanos.common.domain.RealTimeData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author qiliang
 * @date 2018/8/25
 */
@Slf4j
@Component
public class KafkaProducerService {

  @Autowired
  private RedisTemplate<Object, Object> redisTemplate;

  @Value("${redisKey}")
  private String redisKey;


  @Value("${kafka.topic.real-time-data:realTimeDataTopic}")
  private String kafkaTopic;


  @Value("${mock.model:true}")
  private Boolean isMock;

  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;

  /**
   * 获取数据服务
   */
  @Resource
  private FetchDataService fetchDataService;


  @Resource(name = "mockFetchDateService")
  private FetchDataService mockFetchDateService;

  /**
   * 发送消息的线程。
   */
  public void send() {
    if (isMock) {
      fetchDataService = mockFetchDateService;
    }
    Boolean result = false;
    while (!result) {
      try {
        //设置暂停的时间 5 秒
        Thread.sleep(5 * 1000);
        List<RealTimeData> dataList = mockFetchDateService.fetch();

        sendToKafka(dataList);
        fromRedisSend();
      } catch (Exception e) {
        log.error("KafkaProducerService send Exception");
      }
    }

  }


  /**
   * redis 补偿消息队列
   */
  public void fromRedisSend() {
    Boolean result = false;
    try {
      //队列中没有直接结束此次循环
      if (redisTemplate.opsForList().size(redisKey) > 0) {
        //一次取1000条
        List<Object> dataList = redisTemplate.opsForList().range(redisKey, 0, 1000);
        if (!CollectionUtils.isEmpty(dataList)) {
          List<RealTimeData> breakDataList = new ArrayList<>();
          for (Object data : dataList) {
            breakDataList.add((RealTimeData) data);
          }
          sendToKafka(breakDataList);
          redisTemplate.opsForList().remove(redisKey, 0, dataList.size());
        }
      }
    } catch (Exception e) {
      log.error("KafkaProducerService fromRedisSend Exception");
    }

  }

  /**
   * 发送到kafka
   */
  private void sendToKafka(List<RealTimeData> dataList) {
    try {
      if (!CollectionUtils.isEmpty(dataList)) {
        List<RealTimeData> breakDataList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
          if (breakDataList.size() == 20
              || i >= dataList.size()) {

            kafkaTemplate.send(kafkaTopic, JSON.toJSONString(dataList));
            breakDataList.clear();
          } else {
            breakDataList.add(dataList.get(i));
          }
        }

      }
    } catch (Exception e) {
      log.error("发送到kafka失败 加入补偿队列 dataList : {}", dataList);
      try {
        //设置永久有效
        redisTemplate.opsForList().rightPush(redisKey, dataList);

      } catch (Exception exp) {
        log.error("缓存到redis 失败 dataList : {}", dataList);
      }

    }
  }

}
