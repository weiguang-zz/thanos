package com.thanos.portal.domain.monitor;

import com.thanos.common.domain.RealTimeData;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 *
 */
public interface FetchRealTimeDataService {

  /**
   * 获取监控数据，没有更多数据话，就阻塞
   * @return
   */
  List<RealTimeData> fetch();

  List<RealTimeData> fetch(Long timeout, TimeUnit unit);

}
