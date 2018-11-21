package com.thanos.common.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Create by zhangzheng on 11/3/18
 * Email:zhangzheng@youzan.com
 * 测点的领域模型
 */
public class Monitor extends Aggregate {

  //测点代码，由每个工厂定义，系统根据这个code来匹配测点的实时数据
  @Indexed(unique = true)
  String monitorCode;
  ObjectId equipmentInstanceId;//设备实例ID
  String name;
  //测点类型
  MonitorType type;
  Double lowLowThreshold;
  Double lowThreshold;
  Double highThreshold;
  Double highHighThreshold;

  //when lowSS<测点值<highSS, 表示开机，否则表示关机
  Boolean isStopStart = false;
  Double lowSS;
  Double highSS;
}
