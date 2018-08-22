package com.thanos.soulgem.domain.monitor;

import com.thanos.common.domain.RealtimeData;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 *
 */
public interface FetchRealtimeDataService {

  /**
   * 获取监控数据，没有更多数据话，就阻塞
   * @return
   */
  List<RealtimeData> fetch();

  List<RealtimeData> fetch(Long timeout, TimeUnit unit);

}
