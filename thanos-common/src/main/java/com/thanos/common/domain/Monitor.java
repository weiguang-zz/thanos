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
  //如果是设备状态类型的测点，需要关联一个停开机测点
  String relatedCode;
  Double lowLowThreshold;
  Double lowThreshold;
  Double highThreshold;
  Double highHighThreshold;
}
