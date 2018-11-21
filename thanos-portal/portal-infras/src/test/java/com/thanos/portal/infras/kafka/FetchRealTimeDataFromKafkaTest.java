package com.thanos.portal.infras.kafka;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.thanos.common.domain.RealTimeData;
import com.thanos.portal.domain.monitor.FetchRealTimeDataService;
import com.thanos.portal.infras.kafka.spring.KafkaAutoConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create by zhangzheng on 8/22/18
 * Email:zhangzheng@youzan.com
 */
@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KafkaAutoConfig.class, KafkaAutoConfiguration.class})
public class FetchRealTimeDataFromKafkaTest {

  @Autowired
  FetchRealTimeDataService fetchRealTimeDataService;
  @Autowired
  KafkaTemplate<String,String> kafkaTemplate;
  @Autowired
  KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

  private static final String TOPIC = "realTimeDataTopic";
  private Gson gson = new Gson();

  @ClassRule
  public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, TOPIC);

  @Before
  public void setUp() throws Exception {
    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry.getListenerContainers()) {
      ContainerTestUtils.waitForAssignment(messageListenerContainer,
          embeddedKafka.getPartitionsPerTopic());
    }
  }

  @Test
  public void testSendAndFetchData() {
    List<RealTimeData> realTimeData = new ArrayList<>();
    ObjectId someObjectId = new ObjectId("5b52d1d7aa73821baf1f23cb");
    String someCode = "someCode";
    String someValue = "someValue";
    realTimeData.add(new RealTimeData(someObjectId, someCode, someValue));
    kafkaTemplate.send(TOPIC,gson.toJson(realTimeData));

    List<RealTimeData> dataReceived = fetchRealTimeDataService.fetch(500L, TimeUnit.MILLISECONDS);
    assertEquals(1, dataReceived.size());
  }

}
