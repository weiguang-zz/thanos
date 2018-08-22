package com.thanos.common.domain;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 * 采集点的实时数据模型
 */
public class RealtimeData extends Aggregate{

  ObjectId companyId;
  String collectPointCode;
  Date time;
  String value;

  public RealtimeData(ObjectId companyId, String collectPointCode, String value) {
    this.companyId = companyId;
    this.collectPointCode = collectPointCode;
    this.value = value;
    this.time = new Date();
  }
}
