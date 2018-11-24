package com.thanos.portal.domain.monitor;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 * 采集点的实时数据模型
 */
public class RealTimeData {

  ObjectId companyId;
  //如果是设备状态的实时数据，使用'equipment-${equipmentId}'作为monitorCode
  String monitorCode;
  Date time;
  String value;

  public RealTimeData(ObjectId companyId, String monitorCode, String value) {
    this.companyId = companyId;
    this.monitorCode = monitorCode;
    this.value = value;
    this.time = new Date();
  }
}
