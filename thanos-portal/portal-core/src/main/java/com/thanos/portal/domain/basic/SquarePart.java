package com.thanos.portal.domain.basic;

import com.thanos.common.domain.Aggregate;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
public class SquarePart extends Aggregate {

  ObjectId equipmentId;
  String name;
  String specifications;//规格型号
  String installLocation;
  String unit;
  Long initialAmount;//装机数量
  String technicalParameters;//技术参数
  String others;
  String technicalRequirement;
  Long riskyReserve;

  public ObjectId equipmentId() {
    return equipmentId;
  }
}
