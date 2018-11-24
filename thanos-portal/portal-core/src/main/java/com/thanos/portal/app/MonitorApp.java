package com.thanos.portal.app;

import com.thanos.portal.domain.monitor.RealTimeData;
import java.util.List;

/**
 * Create by zhangzheng on 11/24/18
 * Email:zhangzheng@youzan.com
 * 改类给monitor服务提供上传实时数据和获取设备状态的接口
 */
public class MonitorApp {

  /**
   * 上传实时的模拟量和信号量实时数据，返回计算过后的设备状态数据
   * @param realTimeData
   * @return
   */
  public List<RealTimeData> uploadRealTimeData(List<RealTimeData> realTimeData){
    return null;
  }


}
