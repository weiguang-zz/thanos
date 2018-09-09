package com.thanos.spacegem.core;

import com.thanos.common.domain.RealtimeData;

import java.util.List;

/**
 *
 * @author qiliang
 * @date 2018/8/25
 */
public interface FetchDataService {


  /**
   * 获取监控工厂返回的数据
   * @return
   */
  List<RealtimeData> fetch();
}
