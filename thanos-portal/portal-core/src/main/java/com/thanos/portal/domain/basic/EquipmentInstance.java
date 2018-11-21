package com.thanos.portal.domain.basic;

import com.thanos.common.domain.Aggregate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Create by zhangzheng on 11/17/18
 * Email:zhangzheng@youzan.com
 * 设备实例，表示具体的一个设备
 */
public class EquipmentInstance extends Aggregate{
  @DBRef
  Equipment equipment;
  Long number;//设备编号
  String vendor; //厂家
  ObjectId usedDepartmentId;//使用部门
  String productionLineName;
  String productionLineNumber;
  Process process;//工序
  Asset asset;//资产属性
}
