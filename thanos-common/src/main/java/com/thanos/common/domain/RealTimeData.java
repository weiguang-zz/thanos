package com.thanos.common.domain;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 * 采集点的实时数据模型
 */
public class RealTimeData extends Aggregate{

  ObjectId companyId;
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
