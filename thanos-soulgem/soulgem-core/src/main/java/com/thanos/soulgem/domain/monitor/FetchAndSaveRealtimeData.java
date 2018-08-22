package com.thanos.soulgem.domain.monitor;

import com.thanos.common.domain.DomainService;
import com.thanos.common.domain.RealtimeData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class FetchAndSaveRealtimeData implements InitializingBean,Runnable{

  private static final int THREAD_COUNT = 10;
  private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

  private Logger logger = LoggerFactory.getLogger(FetchAndSaveRealtimeData.class);

  @Autowired(required = false)
  FetchRealtimeDataService fetchRealtimeDataService;
  @Autowired
  RealtimeDataRepo realtimeDataRepo;


  @Override
  public void afterPropertiesSet(){
    logger.info("start {} threads to save real time data", THREAD_COUNT);
    for(int i=0;i<THREAD_COUNT;i++){
      executor.execute(this);
    }
  }

  @Override
  public void run() {
    while(true){
      List<RealtimeData> realtimeDatas = fetchRealtimeDataService.fetch();
      realtimeDataRepo.save(realtimeDatas);
      logger.info("save realtime data success,count:{}", realtimeDatas.size());
    }
  }
}
